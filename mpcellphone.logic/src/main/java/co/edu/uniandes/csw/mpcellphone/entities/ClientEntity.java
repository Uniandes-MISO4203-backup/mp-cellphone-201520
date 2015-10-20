package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @generated
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Client.getByUserId", query = "select u from ClientEntity u WHERE u.userId = :userId"),
    @NamedQuery(name = "Client.getByEmail", query = "select u from ClientEntity u WHERE u.email = :email")
})
public class ClientEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Client")
    private Long id;

    private String name;

    private String email;
    
    private String userId;
    
    private String givenName;
    
    private String surname;
    
    private String phone;
    
    private String address;
    
    private String city;
    
    private String country;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItemEntity> shoppingCart;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> order;    
    
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
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     * @generated
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @return 
     * @generated
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * @param givenName
     * @generated
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * @return 
     * @generated
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname
     * @generated
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return 
     * @generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     * @generated
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return 
     * @generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     * @generated
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return 
     * @generated
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     * @generated
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return 
     * @generated
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     * @generated
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return 
     * @generated
     */
    public String getUserId(){
        return userId;
    }

    /**
     * @param userId
     * @generated
     */
    public void setUserId(String userId){
        this.userId = userId;
    }

    /**
     * @return 
     * @generated
     */
    public List<CartItemEntity> getShoppingCart() {
        return shoppingCart;
    }

    /**
     * @param shoppingcart
     * @generated
     */
    public void setShoppingCart(List<CartItemEntity> shoppingcart) {
        this.shoppingCart = shoppingcart;
    }

    /**
     * @return 
     * @generated
     */
    public List<OrderEntity> getOrder() {
        return order;
    }

    /**
     * @param order
     * @generated
     */
    public void setOrder(List<OrderEntity> order) {
        this.order = order;
    }
}
