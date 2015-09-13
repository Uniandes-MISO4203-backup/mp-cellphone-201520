package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @generated
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "User.getUsers", query = "select u from UserEntity u")
})
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "User")
    private Long id;

    private String name;

    private String role;

    private String stormpath;
    
    private String password;
    
        
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }
    
    public String getStormpath(){
        return stormpath;
    }

    public void setStormpath(String stormpath){
        this.stormpath = stormpath;
    }
    
    public String getPassword(){
        return password;
    }

    public void setPassword(String pass){
        this.password = pass;
    }
}
