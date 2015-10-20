/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.dtos;

/**
 *
 * @author m.amaya11
 */
public class PhotoDTO {

    private Long id;
    private String name;
    private String image;
    private ProductDTO product;

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
    public ProductDTO getProduct() {
        return product;
    }
    
    /**
     * @param product
     * @generated
     */
    public void setProduct(ProductDTO product) {
        this.product = product;
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
    
}
