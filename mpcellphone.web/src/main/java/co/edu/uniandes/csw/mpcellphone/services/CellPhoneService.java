package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.ICellPhoneLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.CellPhoneDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProviderDTO;
import co.edu.uniandes.csw.mpcellphone.providers.StatusCreated;
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

/**
 * @generated
 */
@Path("/cellPhones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CellPhoneService {

    @Inject private ICellPhoneLogic cellPhoneLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;
    
    private ProviderDTO provider = (ProviderDTO) SecurityUtils.getSubject().getSession().getAttribute("Client");
    //private String cellPhoneModel;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public CellPhoneDTO createCellPhone(CellPhoneDTO dto) {
        return cellPhoneLogic.createCellPhone(dto, provider.getId());
    }

    /**
     * @generated
     */
    @GET
    public List<CellPhoneDTO> getCellPhones() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", cellPhoneLogic.countCellPhones(provider.getId()));
        }
        return cellPhoneLogic.getCellPhones(page, maxRecords, provider.getId());
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public CellPhoneDTO getCellPhone(@PathParam("id") Long id) {
        return cellPhoneLogic.getCellPhone(id, provider.getId());
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public CellPhoneDTO updateCellPhone(@PathParam("id") Long id, CellPhoneDTO dto) {
        dto.setId(id);
        return cellPhoneLogic.updateCellPhone(dto, provider.getId());
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCellPhone(@PathParam("id") Long id) {
        cellPhoneLogic.deleteCellPhone(id, provider.getId());
        
    }
    
    
}
