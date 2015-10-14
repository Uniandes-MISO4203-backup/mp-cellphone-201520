package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.ProviderEntity;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            Logger.getLogger(ProviderPersistence.class.getName()).log(Level.SEVERE, null, e);
            return new ProviderEntity();
        }
    }

    public ProviderEntity getProviderByEmail(String email){
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("email", email);
            return this.executeSingleNamedQuery("Provider.getByEmail", params);
        } catch (NoResultException e) {            
            Logger.getLogger(ProviderPersistence.class.getName()).log(Level.SEVERE, null, e);
            return new ProviderEntity();
        }
    }
    
    //Para Obtener la lista de Proveedores desarrollado por Miguel Olivares
    public List<String> getProviders() {
        try{            
            List<String> list = executeListNamedQuery("Provider.getProviders");            
            return list;
        } catch(NoResultException e){
            Logger.getLogger(ProviderPersistence.class.getName()).log(Level.SEVERE, null, e);
            return Collections.EMPTY_LIST;
        }
    }
    
    //Para Obtener la lista de Ciudades desarrollado por Miguel Olivares
    public List<String> getCities() {
        try{            
            List<String> list = executeListNamedQuery("Provider.getCities");            
            return list;
        } catch(NoResultException e){
            Logger.getLogger(ProviderPersistence.class.getName()).log(Level.SEVERE, null, e);
            return Collections.EMPTY_LIST;
        }
    }

}
