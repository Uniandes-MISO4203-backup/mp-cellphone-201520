package co.edu.uniandes.csw.mpcellphone.functionalTest;

import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.services.ClientService;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;  
import org.jboss.arquillian.test.api.*;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;  
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import uk.co.jemos.podam.api.PodamFactory;
//import uk.co.jemos.podam.api.PodamFactoryImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Arquillian.class)
public class ClientFunctionalIT {

    private static final String URLRESOURCES = "src/main/webapp"; 
    private static final String URLBASE = "localhost:8080/mpcellphone.web"; 
    private static final String PATHCLIENT = "/#/client"; 
    private static WebDriver driver; 
    private static final int Ok = 200; 
    //private static final int Created = 201; 
    private static final int OkWithoutContent = 204; 
    private static final String CLIENTNAME ="Cliente de pruebas";

    public static List<ClientDTO> data = new ArrayList();

    
    @PersistenceContext
    private EntityManager em;
    
    // Mediante la anotacion @ArquillianResource se obtiene la URL de despliegue de la aplicacion 
    @ArquillianResource 
    URL deploymentURL;

    
    /**
     * Metodo que crea el empaquetamiento y el despliegue de la aplicacion
     * Mpcellphone
     *
     * @return Archive - war
     */
    @Deployment
    public static Archive<?> createDeployment() {
        MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");

        WebArchive war = ShrinkWrap
                // Nombre del Proyecto "mpcellphone.web" seguido de ".war". Debe ser el mismo nombre del proyecto web que contiene los javascript y los  servicios Rest
                .create(WebArchive.class, "mpcellphone.web.war")
                // Se agrega la dependencia a la logica con el nombre groupid:artefactid:version (GAV)
                .addAsLibraries(resolver.artifact("co.edu.uniandes.csw.mpcellphone:mpcellphone.logic:1.0")
                        .resolveAsFiles())
                // Se agregan los compilados de los paquetes que se van a probar
                .addPackage(ClientService.class.getPackage())
                // Se agrega contenido estatico: html y modulos de javascript. 
                .addAsWebResource(new File(URLRESOURCES, "index.html"))
                .merge(ShrinkWrap.create(GenericArchive.class).as(ExplodedImporter.class).importDirectory(URLRESOURCES + "/src/").as(GenericArchive.class), "/src/", Filters.includeAll())
                // El archivo que contiene la configuracion a la base de datos. 
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                // El archivo beans.xml es necesario para injeccion de dependencias. 
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
                // El archivo web.xml es necesario para el despliegue de los servlets
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));

        return war;
    }
   
    
    @BeforeClass 
    public static void setUp() { 
        // Crea una instancia del driver de Firefox sobre el que se ejecutara la aplicacion. 
        driver = new FirefoxDriver();
    }

    @Before 
    public void setUpTest() {  
        insertData(); 
        // El browser va a la url de despliegue. Se ejecuta al iniciar cada uno de los metodos de prueba indicados con @Test
        driver.get(deploymentURL.toString());  
    }
    
    @AfterClass 
    public static void tearDown() throws Exception { 
        //Se ejecuta al terminar todos los metodos de prueba indicados con @Test Cierra el browser 
        driver.quit(); 
    }
    
    private void insertData() {
        for (int i = 0; i < 3; i++) {            
            //PodamFactory factory = new PodamFactoryImpl();
            ClientDTO client = new ClientDTO();
        	client.setName(CLIENTNAME);
            em.persist(client);
            
            //ClientDTO client = factory.manufacturePojo(ClientDTO.class);
            //client.setName(CLIENTNAME);
            Client cliente = ClientBuilder.newClient();
            Response response = cliente.target(URLBASE + PATHCLIENT)
                .request()
                .post(Entity.entity(client, MediaType.APPLICATION_JSON));
            if (response.getStatus()== Ok)
                data.add(client);
        }
    }
    
    @After
    public void clearData() {
        for (int i = 0; i < data.size(); i++) {            
            //PodamFactory factory = new PodamFactoryImpl();
            //ClientDTO client = factory.manufacturePojo(ClientDTO.class);
            Client cliente = ClientBuilder.newClient();
            ClientDTO client = data.get(i);
            Response response = cliente.target(URLBASE + PATHCLIENT + '/' + data.get(i).getId())
                .request()
                .delete();
            if (response.getStatus()== OkWithoutContent)
                data.remove(client);
        }
    }

    /** 
     * El test edita un cliente ya creado. 
     * 
     * @throws java.lang.InterruptedException 
     */ 
    @Test
    @RunAsClient
    public void t2EditClient() throws InterruptedException {
        Thread.sleep(1500);
        boolean success = false;
        String newName = "Nuevo nombre de cliente";
        String newEmail = "email@correo.com";
        driver.findElement(By.id("-edit-btn")).click(); //Hace click en el primer elemento edit-btn encontrado
        Thread.sleep(1000);
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(newName);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(newEmail);
        driver.findElement(By.id("save-client")).click();
        Thread.sleep(1000);
        List<WebElement> clients = driver.findElements(By.xpath("//div[contains(@ng-repeat,'record in records')]"));
        for (WebElement client : clients) {
            List<WebElement> captions = client.findElements(By.xpath("div[contains(@class, 'col-md-4')]/div[contains(@class, 'caption')]/p"));
            if (captions.get(1).getText().contains(newName)
                    && captions.get(2).getText().contains(newEmail)) {
                success = true;
                break;
            }
        }
        assertTrue(success);
    }
    
}

