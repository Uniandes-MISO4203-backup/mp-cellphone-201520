package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Class that represent cellphone imei reported as stolen
 * Used only to query
 * 
 * @author ca.forero10
 */
@Entity
 @NamedQuery(name = "Imei.getByImei", query = "select si from StolenImeiEntity si WHERE si.imei = :imei")
public class StolenImeiEntity implements Serializable{
    
    @Id
    @GeneratedValue(generator = "Imei")
    private Long id;
    private String imei;

    /**
     * 
     * @return entity id
     */
    public Long getId() {
        return id;
    }
     /**
     * 
     * @return cellphone imei
     */
    public String getImei() {
        return imei;
    }
    
     /**
     * 
     * @param imei
     */
    public void setImei(String imei) {
        this.imei = imei;
    }
    
}
