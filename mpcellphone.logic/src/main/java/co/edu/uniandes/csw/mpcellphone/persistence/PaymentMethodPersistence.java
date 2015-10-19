/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.PaymentMethodEntity;
import javax.ejb.Stateless;

/**
 * Clase encargada de contener la comunicacion con la persistencia
 * @author Cindy Hernandez - cv.hernandez10
 */
@Stateless
public class PaymentMethodPersistence extends CrudPersistence<PaymentMethodEntity>{

    /**
     * Constructor de la clase
     */
    public PaymentMethodPersistence() {
        this.entityClass = PaymentMethodEntity.class;
    }
    
    
}
