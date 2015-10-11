package co.edu.uniandes.csw.mpcellphone.dtos;

import java.util.List;
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
    private List<PhotoDTO> photos;
    
    /**
     * @return
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     * @generated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return
     * @generated
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model
     * @generated
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return
     * @generated
     */
    public String getImei() {
        return imei;
    }

    /**
     * @param imei
     * @generated
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * @return
     * @generated
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand
     * @generated
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return
     * @generated
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     * @generated
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return
     * @generated
     */
    public List<PhotoDTO> getPhotos() {
        return photos;
    }

    /**
     * @param photos
     * @generated
     */
    public void setPhotos(List<PhotoDTO> photos) {
        this.photos = photos;
    }
    
    

}
