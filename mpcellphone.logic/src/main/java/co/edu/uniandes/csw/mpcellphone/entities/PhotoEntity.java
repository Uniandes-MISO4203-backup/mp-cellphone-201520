/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entidad relacionada con la tabla que almacena la información de las ciudades.
 * @author Mauricio Amaya m.amaya@unal.edu.co
 */
@Entity
public class PhotoEntity  implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String image;

    
    @ManyToOne
    private ProductEntity product;
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
    public String getImage() {
        return image;
    }
    
    /**
     * @param image
     * @generated
     */
    public void setImage(String image) {
        this.image = image;
    }
    
    /**
     * @return 
     * @generated
     */
    public ProductEntity getProduct() {
        return product;
    }

    /**
     * @param product
     * @generated
     */
    public void setProduct(ProductEntity product) {
        this.product = product;
    }
    
    
}
