package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/*
 @autor jbdel10
*/

/**
 * @generated
 */
@Entity
@Table(name="adminentity") 
@NamedQueries({
    @NamedQuery(name = "Admin.getByUserId", query = "select u from AdminEntity u WHERE u.user = :p_user"),
    @NamedQuery(name = "Admin.getByName", query = "select u from AdminEntity u WHERE u.name = :p_name"),
    @NamedQuery(name = "Admin.getAdmins", query = "select u from AdminEntity u") 
})
public class AdminEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Admin")
    @Column(name="Id")
    private Long id;

    private String name;
    
    //Se crea la relación Uno a Uno con el usuario, 
    //se recomienda hacer lo mismo para el resto de perfiles. 
    @OneToOne(cascade={CascadeType.REMOVE})                                   
    private UserEntity user;
    
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public UserEntity getUser(){
        return user;
    }

    public void setUser(UserEntity user){
        this.user = user;
    }
        
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
