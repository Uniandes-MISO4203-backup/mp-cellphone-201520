package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IOrderLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.OrderDTO;
import co.edu.uniandes.csw.mpcellphone.providers.StatusCreated;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletContext;
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
 * Servicio REST de Order
 *
 * @author Cindy Hernandez - cv.hernandez10
 */
@Path("/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderService {

    @Inject
    private IOrderLogic orderLogic;
    @Context
    private HttpServletResponse response;

    @QueryParam("page")
    private Integer page;
    @QueryParam("maxRecords")
    private Integer maxRecords;

    private ClientDTO client = (ClientDTO) SecurityUtils.getSubject().getSession().getAttribute("Client");
    

    /**
     * Metodo POST del servicio, para crear datos
     * @param dto
     * @return
     */
    @POST
    @StatusCreated
    public OrderDTO createOrder(OrderDTO dto) {
        dto.setDateOrder(new Date());
        dto.setClient(client);
        return orderLogic.createOrder(dto);
    }

    /**
     * Metodo GET, para obtener el listado de ordenes
     * @return
     */
    @GET
    public List<OrderDTO> getOrders() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", orderLogic.countOrder());
        }
        return orderLogic.getOrders(page, maxRecords);
    }

    /**
     * Metodo GET, para obtener un dato especifico al enviar un parametro por
     * URL
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id: \\d+}")
    public OrderDTO getOrder(@PathParam("id") Long id) {
        return orderLogic.getOrder(id);
    }

    /**
     * Metodo PUT, encargado de actualizar informacion de la orden
     *
     * @param id
     * @param dto
     * @return
     */
    @PUT
    @Path("{id: \\d+}")
    public OrderDTO updateOrder(@PathParam("id") Long id, OrderDTO dto) {
        dto.setId(id);
        return orderLogic.updateOrder(dto);
    }

    /**
     * Metodo DELETE, encargado de eliminar una orden
     *
     * @param id
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteOrder(@PathParam("id") Long id) {
        orderLogic.deleteOrder(id);
    }
}
