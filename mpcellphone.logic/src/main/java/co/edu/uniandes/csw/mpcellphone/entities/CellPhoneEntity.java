package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * @generated
 */
@Entity
@NamedQueries({
    //Para Obtener la lista de Modelos, desarrollado por Miguel Olivares
    @NamedQuery(name = "CellPhone.getCellPhoneModel", query = "select Distinct u.model from CellPhoneEntity u"),
    //Para Obtener la lista de Marcas, desarrollado por Miguel Olivares
    @NamedQuery(name = "CellPhone.getCellPhoneBrand", query = "select Distinct u.brand from CellPhoneEntity u"),
    
})
public class CellPhoneEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "CellPhone")
    private Long id;

    private String name;

    private String description;

    private String model;

    private String imei;

    private String brand;

    private String image;
    
    @OneToMany(mappedBy = "cellPhone", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoEntity> photos;

    /**
     * @return
     * @generated
     */
    public Long getId(){
        return id;
    }

    /**
     * @param id
     * @generated
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * @return
     * @generated
     */
    public String getName(){
        return name;
    }

    /**
     * @param name
     * @generated
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @generated
     */
    public String getDescription(){
        return description;
    }

    /**
     * @param description
     * @generated
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * @return
     * @generated
     */
    public String getModel(){
        return model;
    }

    /**
     * @param model
     * @generated
     */
    public void setModel(String model){
        this.model = model;
    }

    /**
     * @return
     * @generated
     */
    public String getImei(){
        return imei;
    }

    /**
     * @param imei
     * @generated
     */
    public void setImei(String imei){
        this.imei = imei;
    }

    /**
     * @return
     * @generated
     */
    public String getBrand(){
        return brand;
    }

    /**
     * @param brand
     * @generated
     */
    public void setBrand(String brand){
        this.brand = brand;
    }

    /**
     * @return
     * @generated
     */
    public String getImage(){
        return image;
    }

    /**
     * @param image
     * @generated
     */
    public void setImage(String image){
        this.image = image;
    }
    
    /**
     * @return
     * @generated
     */
    public List<PhotoEntity> getPhotos() {
        return photos;
    }
    
    /**
     * @param photos
     * @generated
     */
    public void setPhotos(List<PhotoEntity> photos) {
        this.photos = photos;
    }
    
    

}
