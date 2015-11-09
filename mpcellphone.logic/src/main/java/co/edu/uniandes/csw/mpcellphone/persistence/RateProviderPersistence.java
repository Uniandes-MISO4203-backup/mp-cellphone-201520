package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.RateProviderEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author ca.forero10
 */
@Stateless
public class RateProviderPersistence extends CrudPersistence<RateProviderEntity> {
    
    public RateProviderPersistence(){
        this.entityClass = RateProviderEntity.class;
    }
    
     public RateProviderEntity findByProviderClient(Long providerId, Long clientId) {
        try{             
            Query q = em.createQuery("select u from " + entityClass.getSimpleName() + " u where u.provider.id = :idP and u.client.id = :idC");
            q.setParameter("idP", providerId);
            q.setParameter("idC", clientId);
            return (RateProviderEntity) q.getSingleResult();
        }catch(NoResultException e){
            Logger.getLogger(ProductPersistence.class.getName()).log(Level.SEVERE, null, e);
            return new RateProviderEntity();
        }
    }
}