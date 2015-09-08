package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class ProductDTO {

    private Long id;
    private String name;
    private Integer price;
    private Integer discount;
    private CellPhoneDTO cellPhone;
    private ProviderDTO provider;
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
    public Integer getPrice() {
        return price;
    }

    /**
     * @generated
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * @generated
     */
    public CellPhoneDTO getCellPhone() {
        return cellPhone;
    }

    /**
     * @generated
     */
    public void setCellPhone(CellPhoneDTO cellphone) {
        this.cellPhone = cellphone;
    }

    /**
     * @generated
     */
    public ProviderDTO getProvider() {
        return provider;
    }

    /**
     * @generated
     */
    public void setProvider(ProviderDTO provider) {
        this.provider = provider;
    }

}
