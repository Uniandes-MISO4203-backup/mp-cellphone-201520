package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.ProviderEntity;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class ProviderPersistence extends CrudPersistence<ProviderEntity> {

    /**
     * @generated
     */
    public ProviderPersistence() {
        this.entityClass = ProviderEntity.class;
    }
    
    public ProviderEntity getProviderByUserId(String userId){
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("user_id", userId);
            return this.executeSingleNamedQuery("Provider.getByUserId", params);
        } catch (NoResultException e) {
            return null;
        }
    }

    public ProviderEntity getProviderByEmail(String email){
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("email", email);
            return this.executeSingleNamedQuery("Provider.getByUserEmail", params);
        } catch (NoResultException e) {
            return null;
        }
    }

}
