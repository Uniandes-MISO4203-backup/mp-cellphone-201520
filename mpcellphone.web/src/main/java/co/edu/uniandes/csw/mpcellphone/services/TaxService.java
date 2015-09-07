package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.ITaxLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.TaxDTO;
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

/**
 * Servicio REST de Tax
 * @author Cindy Hernandez - cv.hernandez10
 */
@Path("/tax")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaxService {

    @Inject 
    private ITaxLogic taxLogic;
    @Context 
    private HttpServletResponse response;
    
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * Metodo POST del servicio, para crear datos
     * @param dto
     * @return 
     */
    @POST
    @StatusCreated
    public TaxDTO createTax(TaxDTO dto) {
        return taxLogic.createTax(dto);
    }

    /**
     * Metodo GET, para obtener el listado de ordenes
     * @return 
     */
    @GET
    public List<TaxDTO> getTaxs() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", taxLogic.countTax());
        }
        return taxLogic.getTaxs(page, maxRecords);
    }

    /**
     * Metodo GET, para obtener un dato especifico al enviar un parametro por URL
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public TaxDTO getTax(@PathParam("id") Long id) {
        return taxLogic.getTax(id);
    }

    /**
     * Metodo PUT, encargado de actualizar informacion de la orden
     * @param id
     * @param dto
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public TaxDTO updateTax(@PathParam("id") Long id, TaxDTO dto) {
        dto.setId(id);
        return taxLogic.updateTax(dto);
    }

    /**
     * Metodo DELETE, encargado de eliminar una orden
     * @param id 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTax(@PathParam("id") Long id) {
        taxLogic.deleteTax(id);
    }
}
