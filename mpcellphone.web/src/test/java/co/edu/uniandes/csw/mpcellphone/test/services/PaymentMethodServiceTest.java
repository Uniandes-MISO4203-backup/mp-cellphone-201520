package co.edu.uniandes.csw.mpcellphone.test.services;

import co.edu.uniandes.csw.mpcellphone.dtos.PaymentMethodDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.UserDTO;
import co.edu.uniandes.csw.mpcellphone.providers.EJBExceptionMapper;
import co.edu.uniandes.csw.mpcellphone.services.PaymentMethodService;
import co.edu.uniandes.csw.mpcellphone.shiro.ApiKeyProperties;
import co.edu.uniandes.csw.mpcellphone.shiro.AuthcFilter;
import co.edu.uniandes.csw.mpcellphone.shiro.AuthzFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.filter.LoggingFilter;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.netbeans.rest.application.config.ApplicationConfig;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @author cv.hernandez10
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Arquillian.class)
public class PaymentMethodServiceTest {

    public static final String DEPLOY = "Prueba";
    public final static List<PaymentMethodDTO> methodOraculo = new ArrayList<>();
    public final static String URLRESOURCES = "src/main/webapp";
    public final static String URLBASE = "http://localhost:8181/mpcellphone.web/webresources";
    public final static String PATH = "/payment_method";
    public final static int Ok = 200;
    public final static int Created = 201;
    public final static int OkWithoutContent = 204;

    @Deployment
    public static WebArchive createDeployment() {
        MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
        WebArchive war = ShrinkWrap
                // Nombre del Proyecto "mpcellphone.web" seguido de ".war". Debe ser el mismo nombre del proyecto web que contiene los javascript y los  servicios Rest
                .create(WebArchive.class, "mpcellphone.web.war")
                // Se agrega la dependencia a la logica con el nombre groupid:artefactid:version (GAV)
                .addAsLibraries(resolver.artifact("co.edu.uniandes.csw.mpcellphone:mpcellphone.logic:1.0").resolveAsFiles())
                // Se agregan los compilados de los paquetes de servicios
                .addPackage(ApplicationConfig.class.getPackage())
                .addPackage(AuthcFilter.class.getPackage())
                .addPackage(AuthzFilter.class.getPackage())
                .addPackage(ApiKeyProperties.class.getPackage())
                .addPackage(PaymentMethodService.class.getPackage())
                .addPackage(EJBExceptionMapper.class.getPackage())
                // El archivo que contiene la configuracion a la base de datos. 
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                // El archivo shiro.ini 
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/shiro.ini"))
                // El archivo beans.xml es necesario para injeccion de dependencias. 
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
                // El archivo web.xml es necesario para el despliegue de los servlets
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));
        return war;
    }

    @BeforeClass
    public static void setUp() {
        for (int i = 0; i < 5; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            PaymentMethodDTO method = factory.manufacturePojo(PaymentMethodDTO.class);
            methodOraculo.add(method);
        }
    }

    private Cookie login(String username, String password) {
        Client clienteWS = ClientBuilder.newClient();

        UserDTO user = new UserDTO();
        user.setUserName(username);
        user.setPassword(password);

        Response response
                = clienteWS.target(URLBASE)
                .register(LoggingFilter.class)
                .path("users")
                .path("login")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(user, MediaType.APPLICATION_JSON));

        UserDTO foundUser = (UserDTO) response.readEntity(UserDTO.class);

        if (foundUser != null && response.getStatus() == Ok) {
            return response.getCookies().get("JSESSIONID");
        } else {
            return null;
        }
    }

    @Test
    @RunAsClient
    public void t1CreatePaymentMethodService() throws IOException {
        //Cookie cookieSessionId = login("Test", "tesT12345");

        //if (cookieSessionId != null) {
            PaymentMethodDTO method = methodOraculo.get(0);
            Client cliente = ClientBuilder.newClient();
            Response response = cliente.target(URLBASE + PATH).request()
                    .post(Entity.entity(method, MediaType.APPLICATION_JSON));
            PaymentMethodDTO methodTest = (PaymentMethodDTO) response.readEntity(PaymentMethodDTO.class);
            Assert.assertEquals(Created, response.getStatus());
            Assert.assertEquals(method.getMethodName(), methodTest.getMethodName());
        //} else {
          //  Assert.fail("Access denied or Invalid credentials!");
        //}
    }

    @Test
    @RunAsClient
    public void t2GetPaymentMethodService() throws IOException {
//        Cookie cookieSessionId = login("Test", "tesT12345");
//        if (cookieSessionId != null) {
            Client cliente = ClientBuilder.newClient();
            Response response = cliente.target(URLBASE + PATH).request().get();
            String stringPaymentMethod = response.readEntity(String.class);
            List<PaymentMethodDTO> listPaymentMethodTest = new ObjectMapper().readValue(stringPaymentMethod, List.class);
            Assert.assertEquals(Ok, response.getStatus());
            Assert.assertEquals(1, listPaymentMethodTest.size());
//        } else {
//            Assert.fail("Access denied or Invalid credentials!");
//        }
    }

    @Test
    @RunAsClient
    public void t3GetPaymentMethodById() {
        //Cookie cookieSessionId = login("Test", "tesT12345");
        //if (cookieSessionId != null) {
            Client cliente = ClientBuilder.newClient();
            PaymentMethodDTO methodTest = cliente.target(URLBASE + PATH).path("/" + methodOraculo.get(0).getId())
                    .request().get(PaymentMethodDTO.class);
            Assert.assertEquals(methodTest.getMethodName(), methodOraculo.get(0).getMethodName());
        //} else {
            //Assert.fail("Access denied or Invalid credentials!");
        //}
    }

    @Test
    @RunAsClient
    public void t4UpdatePaymentMethodService() throws IOException {
        //Cookie cookieSessionId = login("Test", "tesT12345");
        //if (cookieSessionId != null) {
            PaymentMethodDTO method = methodOraculo.get(0);
            PodamFactory factory = new PodamFactoryImpl();
            PaymentMethodDTO methodChanged = factory.manufacturePojo(PaymentMethodDTO.class);
            method.setMethodName(methodChanged.getMethodName());
            Client cliente = ClientBuilder.newClient();
            Response response = cliente.target(URLBASE + PATH).path("/" + method.getId())
                    .request().put(Entity.entity(method, MediaType.APPLICATION_JSON));
            PaymentMethodDTO methodTest = (PaymentMethodDTO) response.readEntity(PaymentMethodDTO.class);
            Assert.assertEquals(Ok, response.getStatus());
            Assert.assertEquals(method.getMethodName(), methodTest.getMethodName());
        //} else {
         //   Assert.fail("Access denied or Invalid credentials!");
        //}

    }

    @Test
    @RunAsClient
    public void t5DeletePaymentMethodService() {
//        Cookie cookieSessionId = login("Test", "tesT12345");
//        if (cookieSessionId != null) {
            Client cliente = ClientBuilder.newClient();
            PaymentMethodDTO method = methodOraculo.get(0);
            Response response = cliente.target(URLBASE + PATH).path("/" + method.getId()).request().delete();
            Assert.assertEquals(OkWithoutContent, response.getStatus());
//        } else {
//            Assert.fail("Access denied or Invalid credentials!");
//        }
    }
}
