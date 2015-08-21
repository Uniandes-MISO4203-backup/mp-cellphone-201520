package co.edu.uniandes.csw.model.ejbs;

import co.edu.uniandes.csw.model.api.ICartItemLogic;
import co.edu.uniandes.csw.model.converters.CartItemConverter;
import co.edu.uniandes.csw.model.dtos.CartItemDTO;
import co.edu.uniandes.csw.model.entities.CartItemEntity;
import co.edu.uniandes.csw.model.persistence.CartItemPersistence;
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
    public int countCartItems() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<CartItemDTO> getCartItems(Integer page, Integer maxRecords) {
        return CartItemConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public CartItemDTO getCartItem(Long id) {
        return CartItemConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public CartItemDTO createCartItem(CartItemDTO dto) {
        CartItemEntity entity = CartItemConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return CartItemConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public CartItemDTO updateCartItem(CartItemDTO dto) {
        CartItemEntity entity = persistence.update(CartItemConverter.fullDTO2Entity(dto));
        return CartItemConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteCartItem(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<CartItemDTO> findByName(String name) {
        return CartItemConverter.listEntity2DTO(persistence.findByName(name));
    }
}
