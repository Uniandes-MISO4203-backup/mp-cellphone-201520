package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class CellPhoneDTO {

    private Long id;
    private String name;
    private String description;
    private String model;
    private String imei;
    private String brand;
    private String image;
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
    public String getDescription() {
        return description;
    }

    /**
     * @generated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @generated
     */
    public String getModel() {
        return model;
    }

    /**
     * @generated
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @generated
     */
    public String getImei() {
        return imei;
    }

    /**
     * @generated
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * @generated
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @generated
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @generated
     */
    public String getImage() {
        return image;
    }

    /**
     * @generated
     */
    public void setImage(String image) {
        this.image = image;
    }

}
