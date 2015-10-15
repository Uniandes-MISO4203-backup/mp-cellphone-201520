/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Clase donde se almacenan las ventas hechas 
 * @author Cindy
 */
@Entity
public class SalesEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private ProductEntity productId;
    
    @ManyToOne
    private OrderEntity orderId;
    
    @ManyToOne
    private ProviderEntity providerId;
    
    @ManyToOne
    private ClientEntity clientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getProductId() {
        return productId;
    }

    public void setProductId(ProductEntity productId) {
        this.productId = productId;
    }

    public OrderEntity getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderEntity orderId) {
        this.orderId = orderId;
    }

    public ProviderEntity getProviderId() {
        return providerId;
    }

    public void setProviderId(ProviderEntity providerId) {
        this.providerId = providerId;
    }

    public ClientEntity getClientId() {
        return clientId;
    }

    public void setClientId(ClientEntity clientId) {
        this.clientId = clientId;
    }
}
