package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.CartItemDTO;
import java.util.List;

public interface ICartItemLogic {
    public int countCartItems();
    public List<CartItemDTO> getCartItems(Integer page, Integer maxRecords);
    public CartItemDTO getCartItem(Long id);
    public CartItemDTO createCartItem(CartItemDTO dto);
    public CartItemDTO updateCartItem(CartItemDTO dto);
    public void deleteCartItem(Long id);
    public List<CartItemDTO> findByName(String name);
    
    public List<CartItemDTO> getCartItemsByClient(Integer page, Integer maxRecords, Long idClient);
    public CartItemDTO createCartItemByClient(CartItemDTO dto, Long idClient);
    public CartItemDTO getCartItemsByClientById(Long id, Long idClient);
    public CartItemDTO updateCartItemByClient(Long idClient, CartItemDTO dto);
    public void deleteCartItemByClient(Long idClient, Long id);
    public int countCartItemsByClient(Long idClient);
}
