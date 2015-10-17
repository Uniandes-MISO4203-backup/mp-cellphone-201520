package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.ISaleLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.SaleDTO;
import co.edu.uniandes.csw.mpcellphone.entities.SalesEntity;
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
 * Servicio REST de Sale
 * @author Cindy Hernandez - cv.hernandez10
 */
@Path("/sale")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SaleService {

    @Inject 
    private ISaleLogic saleLogic;
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
    public SaleDTO createSale(SaleDTO dto) {
        return saleLogic.createSale(dto);
    }

    /**
     * Metodo GET, para obtener el listado de ordenes
     * @return 
     */
    @GET
    public List<SaleDTO> getSales() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", saleLogic.countSale());
        }
        return saleLogic.getSales(page, maxRecords);
    }

    /**
     * Metodo GET, para obtener un dato especifico al enviar un parametro por URL
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public SaleDTO getSale(@PathParam("id") Long id) {
        return saleLogic.getSale(id);
    }

    /**
     * Metodo GET, para obtener la lista de ordenes por cliente
     * @param id
     * @return 
     */
    @GET
    @Path("/client/{id: \\d+}")
    public List<SaleDTO> getSaleByClient(@PathParam("id") Long id) {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", saleLogic.countSale());
        }
        return saleLogic.getSaleByClient(page, maxRecords, id);
    }

    /**
     * Metodo GET, para obtener la lista de ordenes por cliente
     * @param id
     * @return 
     */
    @GET
    @Path("/provider/{id: \\d+}")
    public List<SaleDTO> getSaleByProvider(@PathParam("id") Long id) {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", saleLogic.countSale());
        }
        return saleLogic.getSaleByProvider(page, maxRecords, id);
    }    
    
    /**
     * Metodo PUT, encargado de actualizar informacion de la orden
     * @param id
     * @param dto
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public SaleDTO updateSale(@PathParam("id") Long id, SaleDTO dto) {
        dto.setId(id);
        return saleLogic.updateSale(dto);
    }

    /**
     * Metodo DELETE, encargado de eliminar una orden
     * @param id 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteSale(@PathParam("id") Long id) {
        saleLogic.deleteSale(id);
    }
}
