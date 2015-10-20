package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.AdminEntity;
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
public class AdminPersistence extends CrudPersistence<AdminEntity> {

    /**
     * @generated
     */
    public AdminPersistence() {
        this.entityClass = AdminEntity.class;
    }
    
    public AdminEntity getAdminByUserId(String userId){
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_user", userId);
            return this.executeSingleNamedQuery("Admin.getByUserId", params);
        } catch (NoResultException e) {            
            Logger.getLogger(AdminPersistence.class.getName()).log(Level.SEVERE, null, e);
            return new AdminEntity();
        }
    }
}
