/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IShippingTypeLogic;
import co.edu.uniandes.csw.mpcellphone.converters.ShipConverter;
import co.edu.uniandes.csw.mpcellphone.converters.ShippingTypeConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.ShipDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ShippingTypeDTO;
import co.edu.uniandes.csw.mpcellphone.entities.ShipEntity;
import co.edu.uniandes.csw.mpcellphone.entities.ShippingTypeEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.ShippingTypePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB relacionado con el comportamiento de un envio
 * @author Cindy Hernandez - cv.hernandez10
 */
@Stateless
public class ShippingTypeLogic implements IShippingTypeLogic {
 
    @Inject
    private ShippingTypePersistence persistence; 
    
    @Override
    public int countShippingType() {
        return persistence.count();
    }

    /**
     * Metodo encargado de obtener las �rdenes de un cliente
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<ShippingTypeDTO> getShippingTypes(Integer page, Integer maxRecords) {
        return ShippingTypeConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * Metodo encargado de obtener una orden solicitada a traves del id de esta
     * @param id
     * @return 
     */
    @Override
    public ShippingTypeDTO getShippingType(Long id) {
        return ShippingTypeConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * Metodo que permite realizar la creaci�n de una orden
     * @param dto
     * @return 
     */
    @Override
    public ShippingTypeDTO createShippingType(ShippingTypeDTO dto) {
        ShippingTypeEntity entity = ShippingTypeConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ShippingTypeConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite actualizar la informaci�n de una orden
     * @param dto
     * @return 
     */
    @Override
    public ShippingTypeDTO updateShippingType(ShippingTypeDTO dto) {
        ShippingTypeEntity entity = persistence.update(ShippingTypeConverter.fullDTO2Entity(dto));
        return ShippingTypeConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite eliminar una orden
     * @param id 
     */
    @Override
    public void deleteShippingType(Long id) {
        persistence.delete(id);
    }
}