package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Product.getByCellPhoneName", query = "select u from ProductEntity u WHERE UPPER(u.cellPhone.name) like :name")
})
@XmlRootElement
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Product")
    private Long id;

    private String name;

    private Integer price;

    @ManyToOne
    private CellPhoneEntity cellPhone;
    @ManyToOne
    private ProviderEntity provider;
    
    /**
     * @generated
     */
    public Long getId(){
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName(){
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @generated
     */
    public Integer getPrice(){
        return price;
    }

    /**
     * @generated
     */
    public void setPrice(Integer price){
        this.price = price;
    }

    /**
     * @generated
     */
    public CellPhoneEntity getCellPhone() {
        return cellPhone;
    }

    /**
     * @generated
     */
    public void setCellPhone(CellPhoneEntity cellphone) {
        this.cellPhone = cellphone;
    }

    /**
     * @generated
     */
    public ProviderEntity getProvider() {
        return provider;
    }

    /**
     * @generated
     */
    public void setProvider(ProviderEntity provider) {
        this.provider = provider;
    }

}
