package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IProviderLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.ProviderDTO;
import co.edu.uniandes.csw.mpcellphone.providers.StatusCreated;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.account.AccountStatus;
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
@Path("/providers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProviderService {

    @Inject private IProviderLogic providerLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public ProviderDTO createProvider(ProviderDTO dto) {
        return providerLogic.createProvider(dto);
    }

    /**
     * @generated
     */
    @GET
    public List<ProviderDTO> getProviders() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", providerLogic.countProviders());
        }
        return providerLogic.getProviders(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public ProviderDTO getProvider(@PathParam("id") Long id) {
        return providerLogic.getProvider(id);
    }

    private Account updateUser(ProviderDTO user) {
        ApplicationRealm realm = ((ApplicationRealm) ((RealmSecurityManager) SecurityUtils.getSecurityManager()).getRealms());
        Client clientPr = realm.getClient();
        Account acct = clientPr.instantiate(Account.class);
        acct.setEmail(user.getEmail());
        acct.setGivenName(user.getGivenName());
        acct.setSurname(user.getSurname());
        acct.setUsername(user.getGivenName() + " " + user.getSurname());
        acct.setStatus(AccountStatus.ENABLED);
        return acct;
    }

    
    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public ProviderDTO updateProvider(@PathParam("id") Long id, ProviderDTO dto) {
        //this.updateUser(dto);
        dto.setId(id);
        return providerLogic.updateProvider(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProvider(@PathParam("id") Long id) {
        providerLogic.deleteProvider(id);
    }
}
