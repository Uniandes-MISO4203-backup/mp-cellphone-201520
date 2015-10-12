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
    //Para Obtener la lista de Modelos, desarrollado por Miguel Olivares
    @NamedQuery(name = "CellPhone.getCellPhoneModel", query = "select Distinct u.name from CellPhoneEntity u"),
    //Para Obtener la lista de Marcas, desarrollado por Miguel Olivares
    @NamedQuery(name = "CellPhone.getCellPhoneBrand", query = "select Distinct u.brand from CellPhoneEntity u"),
    
})
public class CellPhoneEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "CellPhone")
    private Long id;

    private String name;

    private String brand;


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
    public String getBrand(){
        return brand;
    }

    /**
     * @generated
     */
    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}