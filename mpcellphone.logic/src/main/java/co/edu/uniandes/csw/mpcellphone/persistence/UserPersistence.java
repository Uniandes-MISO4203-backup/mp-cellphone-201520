package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.ejbs.UserLogic;
import co.edu.uniandes.csw.mpcellphone.entities.UserEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        } catch (NoResultException ex) {
            Logger.getLogger(UserLogic.class.getName()).log(Level.SEVERE, null, ex);
            return new UserEntity();
        }
    }
    
    public UserEntity getUserByUserName(String userName){
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("name", userName);
        try {
            return this.executeSingleNamedQuery("User.getUserByUserName", parametros);
        } catch (NoResultException ex) {
            Logger.getLogger(UserLogic.class.getName()).log(Level.SEVERE, null, ex);
            return new UserEntity();
        }
    }
    public UserEntity getUserByUserId(String userId){
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("userid", userId);
        try {
            return this.executeSingleNamedQuery("User.getUserByUserId", parametros);
        } catch (NoResultException ex) {
            Logger.getLogger(UserLogic.class.getName()).log(Level.SEVERE, null, ex);
            return new UserEntity();
        }
    }
}
