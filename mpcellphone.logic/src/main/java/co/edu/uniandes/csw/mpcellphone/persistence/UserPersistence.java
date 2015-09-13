package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.UserEntity;
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
}
