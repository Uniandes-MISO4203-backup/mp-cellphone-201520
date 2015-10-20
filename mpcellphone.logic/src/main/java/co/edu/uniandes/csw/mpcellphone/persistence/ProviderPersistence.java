package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.ProviderEntity;
import java.util.ArrayList;
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
            List<ProviderEntity> list = new ArrayList<ProviderEntity>();
            list =  this.executeListNamedQuery("Provider.getByUserId", params);
            return list.get(0);
        } catch (NoResultException e) {            
            Logger.getLogger(ProviderPersistence.class.getName()).log(Level.SEVERE, null, e);
            return new ProviderEntity();
        }
    }

    public ProviderEntity getProviderByEmail(String email){
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("email", email);
            List<ProviderEntity> list = new ArrayList<ProviderEntity>();
            list = this.executeListNamedQuery("Provider.getByEmail", params);
            return list.get(0);
        } catch (NoResultException e) {            
            Logger.getLogger(ProviderPersistence.class.getName()).log(Level.SEVERE, null, e);
            return new ProviderEntity();
        }
    }
    
    //Para Obtener la lista de Proveedores desarrollado por Miguel Olivares
    public List<String> getProviders() {
        try{            
            return executeListNamedQuery("Provider.getProviders");
        } catch(NoResultException e){
            Logger.getLogger(ProviderPersistence.class.getName()).log(Level.SEVERE, null, e);
            return Collections.emptyList();
        }
    }
    
    //Para Obtener la lista de Ciudades desarrollado por Miguel Olivares
    public List<String> getCities() {
        try{            
            return executeListNamedQuery("Provider.getCities");            
        } catch(NoResultException e){
            Logger.getLogger(ProviderPersistence.class.getName()).log(Level.SEVERE, null, e);
            return Collections.emptyList();
        }
    }

}
