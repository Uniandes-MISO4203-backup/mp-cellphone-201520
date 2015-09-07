package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IPaymentMethodLogic;
import co.edu.uniandes.csw.mpcellphone.api.IPaymentMethodLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.PaymentMethodDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.PaymentMethodDTO;
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
 * Servicio REST de PaymentMethod
 * @author Cindy Hernandez - cv.hernandez10
 */
@Path("/payment_method")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentMethodService {

    @Inject 
    private IPaymentMethodLogic paymentMethodLogic;
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
    public PaymentMethodDTO createPaymentMethod(PaymentMethodDTO dto) {
        return paymentMethodLogic.createPaymentMethod(dto);
    }

    /**
     * Metodo GET, para obtener el listado de ordenes
     * @return 
     */
    @GET
    public List<PaymentMethodDTO> getPaymentMethods() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", paymentMethodLogic.countPaymentMethod());
        }
        return paymentMethodLogic.getPaymentMethods(page, maxRecords);
    }

    /**
     * Metodo GET, para obtener un dato especifico al enviar un parámetro por URL
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public PaymentMethodDTO getPaymentMethod(@PathParam("id") Long id) {
        return paymentMethodLogic.getPaymentMethod(id);
    }

    /**
     * Metodo PUT, encargado de actualizar informacion de la orden
     * @param id
     * @param dto
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public PaymentMethodDTO updatePaymentMethod(@PathParam("id") Long id, PaymentMethodDTO dto) {
        dto.setId(id);
        return paymentMethodLogic.updatePaymentMethod(dto);
    }

    /**
     * Metodo DELETE, encargado de eliminar una orden
     * @param id 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePaymentMethod(@PathParam("id") Long id) {
        paymentMethodLogic.deletePaymentMethod(id);
    }
}
