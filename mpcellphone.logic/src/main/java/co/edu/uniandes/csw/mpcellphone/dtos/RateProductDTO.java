package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ca.forero10
 */
@XmlRootElement
public class RateProductDTO {
    
    private Long id;
    private int rate;
    private ProductDTO product;
    private ClientDTO client;

    public ClientDTO getClient() {
        return client;
    }

    public Long getId() {
        return id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public int getRate() {
        return rate;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
    
    public void setRate(int rate) {
        this.rate = rate;
    }
}
