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
    private CellPhoneDTO cellPhone;

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
    public CellPhoneDTO getCellPhone() {
        return cellPhone;
    }
    
    /**
     * @param cellPhone
     * @generated
     */
    public void setCellPhone(CellPhoneDTO cellPhone) {
        this.cellPhone = cellPhone;
    }
    
    
}
