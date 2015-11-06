package co.edu.uniandes.csw.mpcellphone.dtos;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class ProductDTO {

    private Long id;
    private String name;
    private Long price;
    private Integer discount;
    private CellPhoneDTO cellPhone;
    private ProviderDTO provider;
    private String category;
    private List<PhotoDTO> photos;
    private String productState;
    private CityDTO city;
    //Fields added to correct double entity Cesar Forero
    
    private String imei;       
    private String description;       
    private String image;
    
    private int rateCount;
    private int rate;

    /**
     * @return 
     * @generated
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     * @generated
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
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
    public Long getPrice() {
        return price;
    }

    /**
     * @param price
     * @generated
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return 
     * @generated
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * @param discount
     * @generated
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * @return 
     * @generated
     */
    public CellPhoneDTO getCellPhone() {
        return cellPhone;
    }

    /**
     * @param cellphone
     * @generated
     */
    public void setCellPhone(CellPhoneDTO cellphone) {
        this.cellPhone = cellphone;
    }

    /**
     * @return 
     * @generated
     */
    public ProviderDTO getProvider() {
        return provider;
    }

    /**
     * @param provider
     * @generated
     */
    public void setProvider(ProviderDTO provider) {
        this.provider = provider;
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
    /**
     * Get estado del producto
     * @return 
     */
    public String getProductState() {
        return productState;
    }

    /**
     * Set estado del producto
     * @param productState 
     */
    public void setProductState(String productState) {
        this.productState = productState;
    }
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public int getRate() {
        return rate;
    }

    public int getRateCount() {
        return rateCount;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setRateCount(int rateCount) {
        this.rateCount = rateCount;
    }
    
}
