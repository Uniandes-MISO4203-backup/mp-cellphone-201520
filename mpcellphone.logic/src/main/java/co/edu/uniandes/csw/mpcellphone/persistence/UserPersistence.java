package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.ejbs.UserLogic;
import co.edu.uniandes.csw.mpcellphone.entities.UserEntity;
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
public class UserPersistence extends CrudPersistence<UserEntity> {

    /**
     * @generated
     */
    public UserPersistence() {
        this.entityClass = UserEntity.class;
    }
    
    public UserEntity getUserByUserName(String userName){
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("name", userName);
            List<UserEntity> list = new ArrayList<UserEntity>();
            list =  this.executeListNamedQuery("User.getUserByUserName", parametros);
            return list.get(0);
        } catch (NoResultException ex) {
            Logger.getLogger(UserLogic.class.getName()).log(Level.SEVERE, null, ex);
            return new UserEntity();
        }
    }
    public UserEntity getUserByUserId(String idUser){
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idUser", idUser);
            List<UserEntity> list = new ArrayList<UserEntity>();
            list =  this.executeListNamedQuery("User.getUserByUserId", parametros);
            return list.get(0);
        } catch (NoResultException ex) {
            Logger.getLogger(UserLogic.class.getName()).log(Level.SEVERE, null, ex);
            return new UserEntity();
        }
    }
}
