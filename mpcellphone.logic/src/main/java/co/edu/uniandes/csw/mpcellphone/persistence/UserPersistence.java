package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.UserEntity;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class UserPersistence extends CrudPersistence<UserEntity> {

    /**
     * @generated
     */
    public UserPersistence() {
        this.entityClass = UserEntity.class;
    }
    
    public UserEntity getUsers(String userId){
        try {
            return this.executeSingleNamedQuery("User.FindAll");
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public UserEntity getUserByUserName(String userName){
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("name", userName);
        try {
            return this.executeSingleNamedQuery("User.getUserByUserName", parametros);
        } catch (NoResultException e) {
            return null;
        }
    }
}
