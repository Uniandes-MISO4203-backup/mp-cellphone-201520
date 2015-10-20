package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IStolenImeiLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.StolenImeiDTO;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ca.forero10
 */
@Path("/imei")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ImeiService {
    
    
    @Inject private IStolenImeiLogic stoleLogic;
    
    /**
     * Servicio para consultar la existencia de un imai establecer filtros sobre los productos
     * Creado por ma.olivares10
     */
    @GET
    @Path("/check/{imei}")
    public StolenImeiDTO checkImei(@PathParam("imei") String imei) {
        return stoleLogic.getByImei(imei);
    }
}
