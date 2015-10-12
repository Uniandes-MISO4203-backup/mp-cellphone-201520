package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IShippingTypeLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.ShippingTypeDTO;
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
 * Servicio REST de Ship
 * @author Cindy Hernandez - cv.hernandez10
 */
@Path("/shipping_type")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ShippingTypeService {

    @Inject 
    private IShippingTypeLogic shippingTypeLogic;
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
    public ShippingTypeDTO createShip(ShippingTypeDTO dto) {
        return shippingTypeLogic.createShippingType(dto);
    }

    /**
     * Metodo GET, para obtener el listado de ordenes
     * @return 
     */
    @GET
    public List<ShippingTypeDTO> getShips() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", shippingTypeLogic.countShippingType());
        }
        return shippingTypeLogic.getShippingTypes(page, maxRecords);
    }

    /**
     * Metodo GET, para obtener un dato especifico al enviar un parametro por URL
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public ShippingTypeDTO getShip(@PathParam("id") Long id) {
        return shippingTypeLogic.getShippingType(id);
    }

    /**
     * Metodo PUT, encargado de actualizar informacion de la orden
     * @param id
     * @param dto
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public ShippingTypeDTO updateShip(@PathParam("id") Long id, ShippingTypeDTO dto) {
        dto.setId(id);
        return shippingTypeLogic.updateShippingType(dto);
    }

    /**
     * Metodo DELETE, encargado de eliminar una orden
     * @param id 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteShip(@PathParam("id") Long id) {
        shippingTypeLogic.deleteShippingType(id);
    }
}
