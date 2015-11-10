/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.functionalTest;

import co.edu.uniandes.csw.mpcellphone.shiro.ApiKeyProperties;
import co.edu.uniandes.csw.mpcellphone.dtos.CartItemDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.OrderDTO;
import co.edu.uniandes.csw.mpcellphone.services.OrderService;
import co.edu.uniandes.csw.mpcellphone.services.ProductService;
import co.edu.uniandes.csw.mpcellphone.services.UserService;
import co.edu.uniandes.csw.mpcellphone.test.utils.Login;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Cookie;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @author cv.hernandez10
 */
@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CartItemFunctionalIT {
    
    private static WebDriver driver;
    private static Cookie cookieSessionId;
    private static List<CartItemDTO> cartItems = new ArrayList<>();
    private static OrderDTO order;
    
    // Mediante la anotacion @ArquillianResource se obtiene la URL de despliegue de la aplicacion
    @ArquillianResource
    URL deploymentURL;
    
    @Deployment 
    public static Archive<?> createDeployment() { 
        MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");

        WebArchive war = ShrinkWrap 
                // Nombre del Proyecto "BookBasico.web" seguido de ".war". Debe ser el mismo nombre del proyecto web que contiene los javascript y los  servicios Rest
                .create(WebArchive.class, "mpcellphone.web.war") 
                // Se agrega la dependencia a la logica con el nombre groupid:artefactid:version (GAV) 
                .addAsLibraries(resolver.artifact("co.edu.uniandes.csw.mpcellphone:mpcellphone.logic:1.0") 
                        .resolveAsFiles()) 
                // Se agregan los compilados de los paquetes que se van a probar 
                .addPackage(ProductService.class.getPackage())
                .addPackage(UserService.class.getPackage())
                .addPackage(OrderService.class.getPackage())
                .addPackage(ApiKeyProperties.class.getPackage())
                // Se agrega contenido estatico: html y modulos de javascript.  
                .addAsWebResource(new File(Login.URLRESOURCES, "index.html")) 
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(Login.URLRESOURCES).as(GenericArchive.class), "/", Filters.includeAll())
                // El archivo que contiene la configuracion a la base de datos.  
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml") 
                // El archivo shiro.ini. 
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/shiro.ini"))
                // El archivo beans.xml es necesario para injeccion de dependencias.  
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml")) 
                // El archivo web.xml es necesario para el despliegue de los servlets 
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml")); 

        return war; 
    }
    
    @BeforeClass 
    public static void setUp() { 
        insertData();   
        // Crea una instancia del driver de firefox sobre el que se ejecutara la aplicacion. 
       driver = new FirefoxDriver();
       
    }
    
    private static void insertData() {
        
        Login.createSampleUser();
        cookieSessionId = Login.login("TestFinalCesar", "12345TesT");
        for (int i = 0; i < 5; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            cartItems.add(factory.manufacturePojo(CartItemDTO.class));
            cartItems.add(factory.manufacturePojo(CartItemDTO.class));
            order = factory.manufacturePojo(OrderDTO.class);
        }
    }
    
    @Before
    public void setUpTest() {
        // El browser  va a la url de despliegue. Se ejecuta al inicar cada uno de los metodos de prueba indicados con @Test
        driver.get(deploymentURL.toString());
        
    }
    
    @AfterClass
    public static void tearDown() throws Exception {
        //Se ejecuta al terminar todos los metodos de prueba indicados con @Test Cierra el browser
        driver.quit();
    }
    
    /**
     * No Items to add to cart
     * @throws InterruptedException 
     */
    
    @Test(expected = NoSuchElementException.class)
   @RunAsClient
   public void t1addItemToCart() throws InterruptedException {
       boolean success = false;
       Thread.sleep(2000);
       driver.findElement(By.id("0-addToCart-btn")).click();
       assertTrue(success);
       Thread.sleep(1000);
   }
}
