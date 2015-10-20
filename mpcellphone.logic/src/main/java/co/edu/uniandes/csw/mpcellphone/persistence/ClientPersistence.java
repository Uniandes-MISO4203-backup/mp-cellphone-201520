package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.ClientLogic;
import co.edu.uniandes.csw.mpcellphone.entities.ClientEntity;
import java.util.ArrayList;
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
            params.put("userId", userId);
            List<ClientEntity> list = new ArrayList<ClientEntity>();
            list = this.executeListNamedQuery("Client.getByUserId", params);
            return list.get(0);
        } catch (NoResultException ex) {
            Logger.getLogger(ClientLogic.class.getName()).log(Level.SEVERE, null, ex);
            return new ClientEntity();
        }
    }

    public ClientEntity getClientByEmail(String email){
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("email", email);
            List<ClientEntity> list = new ArrayList<ClientEntity>();
            list =  this.executeListNamedQuery("Client.getByEmail", params);
            return list.get(0);
        } catch (NoResultException ex) {
            Logger.getLogger(ClientLogic.class.getName()).log(Level.SEVERE, null, ex);
            return new ClientEntity();
        }
    }

}
