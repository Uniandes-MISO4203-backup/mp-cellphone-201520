package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.converters.SalesConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.SaleDTO;
import co.edu.uniandes.csw.mpcellphone.entities.SalesEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * Clase encargada de contener la comunicacion con la persistencia
 * @author Cindy Hernandez - cv.hernandez10
 */
@Stateless
public class SalePersistence extends CrudPersistence<SalesEntity> {

    /**
     * Constructor de la clase
     */
    public SalePersistence() {
        this.entityClass = SalesEntity.class;
    }

     public List<SaleDTO> getSaleByClient(Integer page, Integer maxRecords, Long idClient) {
        Query q = em.createQuery("select u from " + entityClass.getSimpleName() + " u where u.clientId.id = :idC");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        return SalesConverter.listEntity2DTO(q.setParameter("idC", idClient).getResultList());
    }

     public List<SaleDTO> getSaleByProvider(Integer page, Integer maxRecords, Long idProvider) {
        Query q = em.createQuery("select u from " + entityClass.getSimpleName() + " u where u.providerId.id = :idP");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        return SalesConverter.listEntity2DTO(q.setParameter("idP", idProvider).getResultList());
    }

}
