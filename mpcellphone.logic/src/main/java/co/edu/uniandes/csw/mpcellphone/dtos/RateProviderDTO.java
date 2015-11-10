package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ca.forero10
 */
@XmlRootElement
public class RateProviderDTO {
    
    private Long id;
    private int rate;
    private ProviderDTO provider;
    private ClientDTO client;

    public ClientDTO getClient() {
        return client;
    }

    public Long getId() {
        return id;
    }

    public ProviderDTO getProvider() {
        return provider;
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

    public void setProvider(ProviderDTO provider) {
        this.provider = provider;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
}
