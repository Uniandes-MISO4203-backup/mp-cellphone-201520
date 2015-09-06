/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.PaymentMethodDTO;
import java.util.List;

/**
 * Interfaz del EJB 
 * @author Cindy Hernandez - cv.hernandez10
 */
public interface IPaymentMethodLogic {
    public int countPaymentMethod();
    public List<PaymentMethodDTO> getPaymentMethods(Integer page, Integer maxRecords);
    public PaymentMethodDTO getPaymentMethod(Long id);
    public PaymentMethodDTO createPaymentMethod(PaymentMethodDTO dto);
    public PaymentMethodDTO updatePaymentMethod(PaymentMethodDTO dto);
    public void deletePaymentMethod(Long id);
}
