package co.edu.uniandes.csw.model.services;

import co.edu.uniandes.csw.model.api.IProviderLogic;
import co.edu.uniandes.csw.model.dtos.ProviderDTO;
import co.edu.uniandes.csw.model.providers.StatusCreated;
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

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public ProviderDTO updateProvider(@PathParam("id") Long id, ProviderDTO dto) {
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
