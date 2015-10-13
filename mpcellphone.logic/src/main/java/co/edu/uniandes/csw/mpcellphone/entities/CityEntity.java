/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entidad relacionada con la tabla que almacena la información de las ciudades.
 * @author Mauricio Amaya m.amaya@unal.edu.co
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Product.getByState", query = "select c from CityEntity c WHERE c.state.id = :id"),
})
public class CityEntity  implements Serializable {
    
    @Id
    @GeneratedValue(generator = "City")
    private Long id;
    private String name;
    private Double longitude;
    private Double latitude;

    
    @ManyToOne
    private StateEntity state;
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
    public StateEntity getState() {
        return state;
    }

    /**
     * @param state
     * @generated
     */
    public void setState(StateEntity state) {
        this.state = state;
    }
    
    /**
     * @return 
     * @generated
     */
    public Double getLongitude() {
        return longitude;
    }
    
    /**
     * @param longitude
     * @generated
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
    /**
     * @return 
     * @generated
     */
    public Double getLatitude() {
        return latitude;
    }
    
    /**
     * @param latitude
     * @generated
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    
}
