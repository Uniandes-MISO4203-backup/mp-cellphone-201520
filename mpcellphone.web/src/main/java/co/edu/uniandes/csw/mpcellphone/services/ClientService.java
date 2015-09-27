package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IClientLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.providers.StatusCreated;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.client.Client;
import com.stormpath.shiro.realm.ApplicationRealm;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;

/**
 * @generated
 */
@Path("/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientService {

    @Inject private IClientLogic clientLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @param dto
     * @return 
     * @generated
     */
    @POST
    @StatusCreated
    public ClientDTO createClient(ClientDTO dto) {
        return clientLogic.createClient(dto);
    }

    /**
     * @return 
     * @generated
     */
    @GET
    public List<ClientDTO> getClients() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", clientLogic.countClients());
        }
        return clientLogic.getClients(page, maxRecords);
    }

    /**
     * @param id
     * @return 
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public ClientDTO getClient(@PathParam("id") Long id) {
        return clientLogic.getClient(id);
    }

    private Account updateUser(ClientDTO user) {
        ApplicationRealm realm = ((ApplicationRealm) ((RealmSecurityManager) SecurityUtils.getSecurityManager()).getRealms());
        Client client = realm.getClient();
        Account acct = client.instantiate(Account.class);
        acct.setEmail(user.getEmail());
        acct.setGivenName(user.getGivenName());
        acct.setSurname(user.getSurname());
        acct.setUsername(user.getGivenName() + " " + user.getSurname());
        return acct;
    }

    
    /**
     * @param id
     * @param dto
     * @return 
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public ClientDTO updateClient(@PathParam("id") Long id, ClientDTO dto) {
        this.updateUser(dto);
        dto.setId(id);
        return clientLogic.updateClient(dto);
    }

    /**
     * @param id
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteClient(@PathParam("id") Long id) {
        clientLogic.deleteClient(id);
    }
}
