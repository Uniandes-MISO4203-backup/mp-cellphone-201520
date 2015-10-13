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
    @NamedQuery(name = "User.getUsers", query = "select u from UserEntity u"), 
    @NamedQuery(name = "User.getUserByUserName", query = "select u from UserEntity u where u.name = :name"),
    @NamedQuery(name = "User.getUserByUserId", query = "select u from UserEntity u where u.stormpath = :userid")
})


public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "User")
    private Long id;

    private String name;

    private String role;

    private String stormpath;
    
    private String password;
    
    private String userName;

    private String email;
    
    private boolean rememberMe;
        
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    
}
