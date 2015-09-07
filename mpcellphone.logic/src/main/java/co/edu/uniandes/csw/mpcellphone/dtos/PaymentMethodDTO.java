/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO de la entidad de metodos de pago
 * @author Cindy Hernandez - cv.hernandez10
 */
@XmlRootElement
public class PaymentMethodDTO {
    
    private Long id;
    private String methodName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    
}
