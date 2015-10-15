package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IStolenImeiLogic;
import co.edu.uniandes.csw.mpcellphone.converters.StolenImeiConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.StolenImeiDTO;
import co.edu.uniandes.csw.mpcellphone.persistence.StolenImeiPersistence;
import javax.inject.Inject;

/**
 *
 * @author ca.forero10
 */
public class StolenImeiLogic implements IStolenImeiLogic{
    
    @Inject private StolenImeiPersistence stolenImeiPersistence;

    public StolenImeiDTO getByImei(String imei) {
        return StolenImeiConverter.basicEntity2DTO(stolenImeiPersistence.getByImei(imei));
    }
    
}
