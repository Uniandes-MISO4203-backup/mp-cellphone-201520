/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.ShippingTypeDTO;
import java.util.List;

/**
 * Interfaz del EJB 
 * @author Cindy Hernandez - cv.hernandez10
 */
public interface IShippingTypeLogic {
    public int countShippingType();
    public List<ShippingTypeDTO> getShippingTypes(Integer page, Integer maxRecords);
    public ShippingTypeDTO getShippingType(Long id);
    public ShippingTypeDTO createShippingType(ShippingTypeDTO dto);
    public ShippingTypeDTO updateShippingType(ShippingTypeDTO dto);
    public void deleteShippingType(Long id);
}
