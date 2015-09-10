package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IClientLogic;
import co.edu.uniandes.csw.mpcellphone.api.IProviderLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProviderDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.UserDTO;
//import co.edu.uniandes.csw.mpcellphone.entities.UserEntity;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Servicio REST de Usuarios
 * @author jdelchiaro (jb.del10)
 */
@Path("/AllUsers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AllUserService {
    
    private List<UserDTO> lista;
    
    
    @Inject private IClientLogic clientLogic;
    @Inject private IProviderLogic providerLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;
    
       
    @GET
    public List<UserDTO> getUsers() {
        UserDTO u = new UserDTO();
        ClientDTO c = new ClientDTO();
        ProviderDTO p = new ProviderDTO();
        List<ClientDTO> listClients;
        List<ProviderDTO> listProviders;
        
        //Lista de clientes    
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", clientLogic.countClients());
        }
        listClients = clientLogic.getClients(page, maxRecords);
        
        
        //Proveedores
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", providerLogic.countProviders());
        }
        listProviders = providerLogic.getProviders(page, maxRecords);
        
        lista = null;
        return lista;
    }
   
}

