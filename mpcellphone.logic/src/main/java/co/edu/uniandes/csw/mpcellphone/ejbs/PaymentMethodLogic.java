/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IPaymentMethodLogic;
import co.edu.uniandes.csw.mpcellphone.converters.PaymentMethodConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.PaymentMethodDTO;
import co.edu.uniandes.csw.mpcellphone.entities.PaymentMethodEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.PaymentMethodPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB relacionado con el comportamiento de metodos de pago
 * @author Cindy Hernandez - cv.hernandez10
 */
@Stateless
public class PaymentMethodLogic implements IPaymentMethodLogic {
 
    @Inject
    private PaymentMethodPersistence persistence; 
    
    @Override
    public int countPaymentMethod() {
        return persistence.count();
    }

    /**
     * Metodo encargado de obtener las órdenes de un cliente
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<PaymentMethodDTO> getPaymentMethods(Integer page, Integer maxRecords) {
        return PaymentMethodConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * Metodo encargado de obtener una orden solicitada a traves del id de esta
     * @param id
     * @return 
     */
    @Override
    public PaymentMethodDTO getPaymentMethod(Long id) {
        return PaymentMethodConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * Metodo que permite realizar la creación de una orden
     * @param dto
     * @return 
     */
    @Override
    public PaymentMethodDTO createPaymentMethod(PaymentMethodDTO dto) {
        PaymentMethodEntity entity = PaymentMethodConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return PaymentMethodConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite actualizar la información de una orden
     * @param dto
     * @return 
     */
    @Override
    public PaymentMethodDTO updatePaymentMethod(PaymentMethodDTO dto) {
        PaymentMethodEntity entity = persistence.update(PaymentMethodConverter.fullDTO2Entity(dto));
        return PaymentMethodConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite eliminar una orden
     * @param id 
     */
    @Override
    public void deletePaymentMethod(Long id) {
        persistence.delete(id);
    }
}