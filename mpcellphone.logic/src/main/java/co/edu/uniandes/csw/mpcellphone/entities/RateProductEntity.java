package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ca.forero10
 */
@Entity
public class RateProductEntity implements Serializable {
    
    @Id
    @GeneratedValue(generator = "RateProduct")
    private Long id;
    private int rate;
    
    @ManyToOne
    private ProductEntity product;
    
    @ManyToOne
    private ClientEntity client;

    /**
     * 
     * @return client
     */
    public ClientEntity getClient() {
        return client;
    }

    /**
     * 
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @return product
     */
    public ProductEntity getProduct() {
        return product;
    }

    /**
     * 
     * @return rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * Modify client
     * @param client 
     */
    public void setClient(ClientEntity client) {
        this.client = client;
    }

    /**
     * Modify id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Modify product
     * @param product 
     */    
    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    /**
     * Modify rate
     * @param rate 
     */
    public void setRate(int rate) {
        this.rate = rate;
    }
}
