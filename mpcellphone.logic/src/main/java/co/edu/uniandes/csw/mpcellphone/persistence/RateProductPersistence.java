package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.RateProductEntity;

/**
 *
 * @author ca.forero10
 */
public class RateProductPersistence  extends CrudPersistence<RateProductEntity> {
    
    public RateProductPersistence(){
        this.entityClass = RateProductEntity.class;
    }
}
