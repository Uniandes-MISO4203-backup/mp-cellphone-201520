package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.ICartItemLogic;
import co.edu.uniandes.csw.mpcellphone.converters.CartItemConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.CartItemDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CartItemEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.CartItemPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class CartItemLogic implements ICartItemLogic {

    @Inject private CartItemPersistence persistence;

    /**
     * @generated
     */
    @Override
    public int countCartItems() {
        return persistence.count();
    }

    /**
     * @generated
     */
    @Override
    public List<CartItemDTO> getCartItems(Integer page, Integer maxRecords) {
        return CartItemConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    @Override
    public CartItemDTO getCartItem(Long id) {
        return CartItemConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    @Override
    public CartItemDTO createCartItem(CartItemDTO dto) {
        CartItemEntity entity = CartItemConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return CartItemConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public CartItemDTO updateCartItem(CartItemDTO dto) {
        CartItemEntity entity = persistence.update(CartItemConverter.fullDTO2Entity(dto));
        return CartItemConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public void deleteCartItem(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    @Override
    public List<CartItemDTO> findByName(String name) {
        return CartItemConverter.listEntity2DTO(persistence.findByName(name));
    }
    
    @Override
    public List<CartItemDTO> getCartItemsByClient(Integer page, Integer maxRecords, Long idClient) {
        return persistence.getCartItemsByClient(page, maxRecords, idClient);
    }

    @Override
    public CartItemDTO createCartItemByClient(CartItemDTO dto, Long idClient) {
        return persistence.createCartItemByClient(dto, idClient);
    }

    @Override
    public CartItemDTO getCartItemsByClientById(Long id, Long idClient) {
        return persistence.getCartItemsByClientById(idClient, idClient);
    }

    @Override
    public CartItemDTO updateCartItemByClient(Long idClient, CartItemDTO dto) {
        CartItemDTO result = new CartItemDTO();
        if (dto.getClient().getId().equals(idClient)) {
            result = updateCartItem(dto);
        }
        return result;
    }

    @Override
    public void deleteCartItemByClient(Long idClient, Long id) {
        persistence.deleteCartItemByClient(idClient, id);
    }

    @Override
    public int countCartItemsByClient(Long idClient) {
        return persistence.countByClient(idClient);
    }
}
