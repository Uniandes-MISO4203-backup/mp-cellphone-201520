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
    @NamedQuery(name = "Provider.getByUserId", query = "select u from ProviderEntity u WHERE u.userId = :user_id")
})
public class ProviderEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Provider")
    private Long id;

    private String name;

    private String userId;
    
    private String email;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products;
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
    public String getUserId(){
        return userId;
    }

    /**
     * @generated
     */
    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @generated
     */
    public List<ProductEntity> getProducts() {
        return products;
    }

    /**
     * @generated
     */
    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

}
