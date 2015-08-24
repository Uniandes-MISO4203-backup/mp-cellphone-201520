package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.converters.CartItemConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.CartItemDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CartItemEntity;
import co.edu.uniandes.csw.mpcellphone.entities.ClientEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * @generated
 */
@Stateless
public class CartItemPersistence extends CrudPersistence<CartItemEntity> {

    /**
     * @generated
     */
    public CartItemPersistence() {
        this.entityClass = CartItemEntity.class;
    }
    
     public List<CartItemDTO> getCartItemsByClient(Integer page, Integer maxRecords, Long idClient) {
        Query q = em.createQuery("select u from " + entityClass.getSimpleName() + " u where u.client.id = :idC");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        return CartItemConverter.listEntity2DTO(q.setParameter("idC", idClient).getResultList());
    }
    
    public CartItemDTO createCartItemByClient(CartItemDTO dto, Long idClient) {
        CartItemEntity entity = CartItemConverter.fullDTO2Entity(dto);
        ClientEntity clientEntity = em.find(ClientEntity.class, idClient);
        entity.setClient(clientEntity);
        em.persist(entity);
        return CartItemConverter.fullEntity2DTO(entity);
    }

    public CartItemDTO getCartItemsByClientById(Long idCart, Long idClient) {
        Query q = em.createQuery("select u from " + entityClass.getSimpleName() + " u where u.client.id = :idC and u.id= :id");
        return CartItemConverter.fullEntity2DTO((CartItemEntity) q.setParameter("idC", idClient).setParameter("id", idCart).getSingleResult());
    }


    public void deleteCartItemByClient(Long idClient, Long id) {
        ClientEntity clientEntity = em.find(ClientEntity.class, idClient);
        if (clientEntity.getId().equals(em.find(CartItemEntity.class, id).getClient().getId())) {
            delete(id);
        }
    }
    
    public int countByClient(Long idClient) {
        Query count = em.createQuery("select count(u) from " + entityClass.getSimpleName() + " u where u.client.id = :idC");
        int regCount = Integer.parseInt(count.setParameter("idC",idClient).getSingleResult().toString());
        return regCount;
    }
}
