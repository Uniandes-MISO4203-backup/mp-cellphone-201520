package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.ITransactionLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.TransactionDTO;
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
 * Servicio REST de Transaction
 * @author Cindy Hernandez - cv.hernandez10
 */
@Path("/pay")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionService {

    @Inject 
    private ITransactionLogic transactionLogic;
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
    public TransactionDTO createTransaction(TransactionDTO dto) {
        return transactionLogic.createTransaction(dto);
    }

    /**
     * Metodo GET, para obtener el listado de ordenes
     * @return 
     */
    @GET
    public List<TransactionDTO> getTransactions() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", transactionLogic.countTransaction());
        }
        return transactionLogic.getTransactions(page, maxRecords);
    }

    /**
     * Metodo GET, para obtener un dato especifico al enviar un parámetro por URL
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public TransactionDTO getTransaction(@PathParam("id") Long id) {
        return transactionLogic.getTransaction(id);
    }

    /**
     * Metodo PUT, encargado de actualizar informacion de la orden
     * @param id
     * @param dto
     * @return 
     */
    @PUT
    @Path("{id: \\d+}")
    public TransactionDTO updateTransaction(@PathParam("id") Long id, TransactionDTO dto) {
        dto.setId(id);
        return transactionLogic.updateTransaction(dto);
    }

    /**
     * Metodo DELETE, encargado de eliminar una orden
     * @param id 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTransaction(@PathParam("id") Long id) {
        transactionLogic.deleteTransaction(id);
    }
}
