/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO correspondiente a los tipos de envio
 * @author Cindy
 */
@XmlRootElement
public class ShippingTypeDTO {

    private Long id;  
    private String name;    
    private Long valueType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValueType() {
        return valueType;
    }

    public void setValueType(Long valueType) {
        this.valueType = valueType;
    }
    
}
