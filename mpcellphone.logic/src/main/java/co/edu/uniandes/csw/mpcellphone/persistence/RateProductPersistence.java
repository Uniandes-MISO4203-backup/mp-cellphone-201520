package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.RateProductEntity;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author ca.forero10
 */
public class RateProductPersistence  extends CrudPersistence<RateProductEntity> {
    
    public RateProductPersistence(){
        this.entityClass = RateProductEntity.class;
    }

    public RateProductEntity findByProductClient(Long productId, Long clientId) {
        try{             
            Query q = em.createQuery("select u from " + entityClass.getSimpleName() + " u where u.product.id = :idP and u.client.id = :idC");
            q.setParameter("idP", productId);
            q.setParameter("idC", clientId);
            return (RateProductEntity) q.getSingleResult();
        }catch(NoResultException e){
            Logger.getLogger(ProductPersistence.class.getName()).log(Level.SEVERE, null, e);
            return new RateProductEntity();
        }
    }
}
