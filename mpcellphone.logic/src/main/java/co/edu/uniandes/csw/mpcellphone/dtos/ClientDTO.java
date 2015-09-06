package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement 
public class ClientDTO {

    private Long id;
    private String name;
    private String userId;
    private List<CartItemDTO> shoppingCart;
    private List<OrderDTO> order;
    /**
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @generated
     */
    public void setUserId(String userid) {
        this.userId = userid;
    }

    /**
     * @generated
     */
    public List<CartItemDTO> getShoppingCart() {
        return shoppingCart;
    }

    /**
     * @generated
     */
    public void setShoppingCart(List<CartItemDTO> shoppingcart) {
        this.shoppingCart = shoppingcart;
    }

    public List<OrderDTO> getOrder() {
        return order;
    }

    public void setOrder(List<OrderDTO> order) {
        this.order = order;
    }
       
}
