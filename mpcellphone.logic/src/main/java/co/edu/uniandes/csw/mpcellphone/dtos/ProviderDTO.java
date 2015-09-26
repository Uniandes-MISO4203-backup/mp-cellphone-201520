package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement 
public class ProviderDTO {

    private Long id;
    private String name;
    private String userId;
    private String email;
    private String givenName;
    private String surname;
    private String phone;
    private String address;
    private String city;
    private String country;
    private List<ProductDTO> products;
    private Integer calification;

    /**
     * @return 
     * @generated
     */
    public Long getId() {
        return id;
    }

    public Integer getCalification() {
        return calification;
    }

    public void setCalification(Integer calification) {
        this.calification = calification;
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
    public String getUserId() {
        return userId;
    }

    /**
     * @param userid
     * @generated
     */
    public void setUserId(String userid) {
        this.userId = userid;
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
    public List<ProductDTO> getProducts() {
        return products;
    }

    /**
     * @param products
     * @generated
     */
    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

}
