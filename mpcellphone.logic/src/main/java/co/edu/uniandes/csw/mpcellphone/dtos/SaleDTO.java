/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO referente a los datos de la venta
 * @author Cindy Hernandez - cv.hernandez10
 */
@XmlRootElement
public class SaleDTO {

    private Long id;
    private ProductDTO productId;
    private OrderDTO orderId;
    private ProviderDTO providerId;
    private ClientDTO clientId;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }   

    public ProductDTO getProductId() {
        return productId;
    }

    public void setProductId(ProductDTO productId) {
        this.productId = productId;
    }

    public OrderDTO getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderDTO orderId) {
        this.orderId = orderId;
    }

    public ProviderDTO getProviderId() {
        return providerId;
    }

    public void setProviderId(ProviderDTO providerId) {
        this.providerId = providerId;
    }

    public ClientDTO getClientId() {
        return clientId;
    }

    public void setClientId(ClientDTO clientId) {
        this.clientId = clientId;
    }
}
