package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ca.forero10
 */
@Entity
public class RateProviderEntity implements Serializable {
    
    @Id
    @GeneratedValue(generator = "RateProvider")
    private Long id;
    private int rate;
    
    @ManyToOne
    private ProviderEntity provider;
    
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
     * @return provider
     */
    public ProviderEntity getProvider() {
        return provider;
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
     * Modify provider
     * @param provider 
     */    
    public void setProvider(ProviderEntity provider) {
        this.provider = provider;
    }

    /**
     * Modify rate
     * @param rate 
     */
    public void setRate(int rate) {
        this.rate = rate;
    }
}
