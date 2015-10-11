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

/**
 * Entidad relacionada con la tabla que almacena la información de los estados.
 * @author Mauricio Amaya m.amaya@unal.edu.co
 */
@Entity
public class StateEntity  implements Serializable {
    
    @Id
    @GeneratedValue(generator = "State")
    private Long id;
    private String name;
    
    
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
    
}
