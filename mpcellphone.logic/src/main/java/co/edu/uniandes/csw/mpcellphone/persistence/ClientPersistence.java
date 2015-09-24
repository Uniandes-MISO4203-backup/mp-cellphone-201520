package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.ClientEntity;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class ClientPersistence extends CrudPersistence<ClientEntity> {

    /**
     * @generated
     */
    public ClientPersistence() {
        this.entityClass = ClientEntity.class;
    }
    
    public ClientEntity getClientByUserId(String userId){
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("user_id", userId);
            return this.executeSingleNamedQuery("Client.getByUserId", params);
        } catch (NoResultException e) {
            return null;
        }
    }

    public ClientEntity getClientByEmail(String email){
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("email", email);
            return this.executeSingleNamedQuery("Client.getByUserEmail", params);
        } catch (NoResultException e) {
            return null;
        }
    }

}
