package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.StolenImeiEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 *
 * @author ca.forero10
 */
@Stateless
public class StolenImeiPersistence extends CrudPersistence<StolenImeiEntity>{

    public StolenImeiPersistence() {
        this.entityClass = StolenImeiEntity.class;
    }
    
    /**
     * 
     * @param imei
     * @return StolenImei empty in case of error.
     */
    public StolenImeiEntity getByImei(String imei) {
        try{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("imei",imei);
            return  executeSingleNamedQuery("Imei.getByImei", params);
        } catch(NoResultException e){
            Logger.getLogger(StolenImeiPersistence.class.getName()).log(Level.SEVERE, null, e);
            return new StolenImeiEntity();
        }
    }
}
