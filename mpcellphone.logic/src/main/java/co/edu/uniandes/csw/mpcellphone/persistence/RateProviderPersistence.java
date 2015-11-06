package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.RateProviderEntity;

/**
 *
 * @author ca.forero10
 */
public class RateProviderPersistence extends CrudPersistence<RateProviderEntity> {
    
    public RateProviderPersistence(){
        this.entityClass = RateProviderEntity.class;
    }
}