package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Autor jbdel10
 */
@XmlRootElement 
public class AdminDTO {    
    
    private Long id; //Id Admin
    private String name;
    private UserDTO user; //Usuario
    private String email;
    
    /**
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @generated
     */
    public UserDTO getUser() {
        return user;
    }

    /**
     * @generated
     */
    public void setUser (UserDTO user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//Futuros programas específicos del rol administrador
 
}
