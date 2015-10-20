package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.StolenImeiDTO;

/**
 *
 * @author ca.forero10
 */
public interface IStolenImeiLogic {
    
    public StolenImeiDTO getByImei(String imei);
    
}
