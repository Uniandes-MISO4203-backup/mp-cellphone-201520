package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mp.ann.MPLoCAnn;
import co.edu.uniandes.csw.mpcellphone.api.IProviderLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.ProviderDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.UserDTO;
import co.edu.uniandes.csw.mpcellphone.providers.StatusCreated;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.account.AccountStatus;
import com.stormpath.sdk.client.*;
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
     * @param dto
     * @return 
     * @generated
     */
    @POST
    @StatusCreated
    public ProviderDTO createProvider(ProviderDTO dto) {
        return providerLogic.createProvider(dto);
    }

    /**
     * @return 
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
     * @param id
     * @return 
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public ProviderDTO getProvider(@PathParam("id") Long id) {
        return providerLogic.getProvider(id);
    }

    @MPLoCAnn(tier="Services", reqId="REQ-43")
    private Account updateUser(ProviderDTO user) {
        //Instancia el cliente stormpath
        String path = "/stormpath/apiKey.properties";
        ApiKey apiKey = ApiKeys.builder().setFileLocation(path).build();
        Client client = Clients.builder().setApiKey(apiKey).build();
        //Carga los datos a la cuenta
        String href = user.getUserId();
        Account acct = client.getDataStore().getResource(href, Account.class);
        //Actualiza y persiste los datos
        acct.setEmail(user.getEmail())
            .setGivenName(user.getGivenName())
            .setSurname(user.getSurname())
            .setUsername(user.getGivenName() + " " + user.getSurname())
            .setStatus(AccountStatus.ENABLED)
            .save();
        return acct;
    }

    @POST 
    @Path("/provider/chgpwdP")
    @StatusCreated
    @MPLoCAnn(tier="Services", reqId="REQ-43")
    public Account changePasswordP (UserDTO dto) {
        //Instancia el cliente stormpath
        String path = "/stormpath/apiKey.properties";
        ApiKey apiKey = ApiKeys.builder().setFileLocation(path).build();
        Client client = Clients.builder().setApiKey(apiKey).build();
        String href = dto.getStormpath();
        String password = dto.getPassword();
        Account acct = client.getDataStore().getResource(href, Account.class);
        //Actualiza y persiste los datos
        acct.setPassword(password)
            .save();
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
    public ProviderDTO updateProvider(@PathParam("id") Long id, ProviderDTO dto) {
        dto.setId(id);
        updateUser(dto);
        return providerLogic.updateProvider(dto);
    }

    /**
     * @param id
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteProvider(@PathParam("id") Long id) {
        providerLogic.deleteProvider(id);
    }
}
