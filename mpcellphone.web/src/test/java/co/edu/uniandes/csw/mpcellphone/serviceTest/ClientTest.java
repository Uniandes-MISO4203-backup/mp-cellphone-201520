package co.edu.uniandes.csw.mpcellphone.serviceTest;

import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.providers.EJBExceptionMapper;
import co.edu.uniandes.csw.mpcellphone.services.ClientService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
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
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @author cv.hernandez10
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Arquillian.class)
public class ClientTest {

    private static final String URLRESOURCES = "src/main/webapp"; 
    private static final String URLBASE = "localhost:8080/mpcellphone.web"; 
    private static final String PATHCLIENT = "/#/client"; 
    public final static int Ok = 200;
    public final static int Created = 201;
    public final static int OkWithoutContent = 204;

    public static List<ClientDTO> data = new ArrayList();
    
    @Deployment
    public static Archive<?> createDeployment() {

        MavenDependencyResolver resolver = DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
        WebArchive war = ShrinkWrap
                // Nombre del Proyecto "mpcellphone.web" seguido de ".war". Debe ser el mismo nombre del proyecto web que contiene los javascript y los  servicios Rest
                .create(WebArchive.class, "mpcellphone.web.war")
                // Se agrega la dependencia a la logica con el nombre groupid:artefactid:version (GAV)
                .addAsLibraries(resolver.artifact("co.edu.uniandes.csw.mpcellphone:mpcellphone.logic:1.0")
                        .resolveAsFiles())
                // Se agregan los compilados de los paquetes de servicios
                .addPackage(ClientService.class.getPackage())
                .addPackage(EJBExceptionMapper.class.getPackage())
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
        for (int i = 0; i < 5; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            ClientDTO client = factory.manufacturePojo(ClientDTO.class);
            data.add(client);
        }
    }


    @Test
    @RunAsClient
    public void t1GetClientById() {
        Client cliente = ClientBuilder.newClient();
        ClientDTO dto = cliente.target(URLBASE + PATHCLIENT).path("/" + data.get(0).getId())
                .request().get(ClientDTO.class);
        Assert.assertEquals(dto.getName(), data.get(0).getName());
    }

    @Test
    @RunAsClient
    public void t1UpdateClientService() throws IOException {
        ClientDTO client = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ClientDTO clientChanged = factory.manufacturePojo(ClientDTO.class);
        client.setName(clientChanged.getName());
        client.setEmail(clientChanged.getEmail());
        Client cliente = ClientBuilder.newClient();
        Response response = cliente.target(URLBASE + PATHCLIENT).path("/" + client.getId())
                .request().put(Entity.entity(client, MediaType.APPLICATION_JSON));
        ClientDTO clientTest = (ClientDTO) response.readEntity(ClientDTO.class);
        Assert.assertEquals(Ok, response.getStatus());
        Assert.assertEquals(client.getName(), clientTest.getName());
        Assert.assertEquals(client.getEmail(), clientTest.getEmail());

    }
    
}
