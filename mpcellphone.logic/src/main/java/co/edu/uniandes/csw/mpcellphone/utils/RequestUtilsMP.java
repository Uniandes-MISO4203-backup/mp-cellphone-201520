package co.edu.uniandes.csw.mpcellphone.utils;

import co.edu.uniandes.csw.mpcellphone.dtos.StolenImeiDTO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Class used to do request to external services
 * @author ca.forero10
 */
public class RequestUtilsMP {
    
    public static final String URLBASE = "http://localhost:8080/mpcellphone.web/webresources";
    public static final String PATHIMEI= "/imei/check";
    
    public static boolean isStolenImei(String imei){
        Client cliente = ClientBuilder.newClient();
        StolenImeiDTO request = cliente.target(URLBASE + PATHIMEI).path("/" + imei)
                .request().get(StolenImeiDTO.class);
        return request!=null&&request.getId()!=null;
    }
}
