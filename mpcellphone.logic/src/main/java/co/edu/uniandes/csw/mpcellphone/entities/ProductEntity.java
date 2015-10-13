package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * @generated
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Product.getByCellPhoneName", query = "select u from ProductEntity u WHERE UPPER(u.name) like :name"),
    @NamedQuery(name = "Product.getCheaperProduct", query = "select u from ProductEntity u WHERE u.cellPhone.id = :idProvider order by u.price"),
    @NamedQuery(name = "Product.getCheaperProvider", query = "select u from ProductEntity u WHERE u.provider.id = :idCellPhone order by u.price"),
    //Query para Obtener la lista de productos de un Modelo Especifico desarrollado por Miguel Olivares
    @NamedQuery(name = "Product.getByModel", query = "select u from ProductEntity u WHere u.cellPhone.name = :model"),
    //Query para Obtener la lista de productos de una Marca Especifico desarrollado por Miguel Olivares
    @NamedQuery(name = "Product.getByBrand", query = "select u from ProductEntity u WHere u.cellPhone.brand = :brand"),
    //Query para Obtener la lista de productos de un Proveedor Especifico desarrollado por Miguel Olivares
    @NamedQuery(name = "Product.getByProviderName", query = "select u from ProductEntity u WHere u.provider.name = :name"),
    //Query para Obtener la lista de productos en una ciudad Especifica desarrollado por Miguel Olivares
    @NamedQuery(name = "Product.getByCity", query = "select u from ProductEntity u WHere u.provider.city = :city"),
    //Query para Obtener la lista de productos en una rango de precio desarrollado por Miguel Olivares
    @NamedQuery(name = "Product.getByPriceRange", query = "select u from ProductEntity u WHERE u.price BETWEEN :minPrice AND :maxPrice"),
    //Query para Obtener la lista de productos en orden de descuento desarrollado por Miguel Olivares
    @NamedQuery(name = "Product.getByDiscount", query = "select u from ProductEntity u WHERE u.discount > 0 order by u.discount DESC"),
    //Query para Obtener la lista de productos por categoria desarrollado por Miguel Olivares
    @NamedQuery(name = "Product.getByCategory", query = "select u from ProductEntity u WHERE u.category = :category"),
    //Query para Obtener la lista de productos por categoria desarrollado por Miguel Olivares
    @NamedQuery(name = "Product.getCategories", query = "select Distinct u.category from ProductEntity u"),
    //Query para obtener la lista de productos de un Proveedor   
    @NamedQuery(name = "Product.getProductsByProvider", query = "select u from ProductEntity u where u.provider.id =:idProvider"),
    //Query para obtener el conteo de productos de un proveedor
    @NamedQuery(name = "Product.getCountProductsByProvider", query = "select count(u) from ProductEntity u where u.provider.id =:idProvider ")    
   
        
})
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Product")
    private Long id;

    private String name;

    private Long price;
    
    private Integer discount;

    @ManyToOne
    private CellPhoneEntity cellPhone;
    
    @ManyToOne
    private ProviderEntity provider;
    
    private String category;
    
    private String productState;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoEntity> photos;
    
    @ManyToOne
    private CityEntity city;
    
    //Fields added to correct double entity Cesar Forero
    
    private String imei;    
    
    private String description;
        
    private String image;

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
     * @return
     * @generated
     */
    public Long getPrice(){
        return price;
    }

    /**
     * @param price
     * @generated
     */
    public void setPrice(Long price){
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
    public CellPhoneEntity getCellPhone() {
        return cellPhone;
    }

    /**
     * @param cellphone
     * @generated
     */
    public void setCellPhone(CellPhoneEntity cellphone) {
        this.cellPhone = cellphone;
    }
    
    /**
     * @return
     * @generated
     */
    public ProviderEntity getProvider() {
        return provider;
    }

    /**
     * @param provider
     * @generated
     */
    public void setProvider(ProviderEntity provider) {
        this.provider = provider;
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
    
    /**
     * @return
     * @generated
     */
    public CityEntity getCity() {
        return city;
    }
    
    /**
     * @param city
     * @generated
     */
    public void setCity(CityEntity city) {
        this.city = city;
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
}
