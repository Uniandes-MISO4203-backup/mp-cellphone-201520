package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *  DTO class of StolenImeiEntity
 * @author ca.forero10
 */
@XmlRootElement 
public class StolenImeiDTO {
    
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
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 
     * @param imei 
     */    
    public void setImei(String imei) {
        this.imei = imei;
    }
    
}
