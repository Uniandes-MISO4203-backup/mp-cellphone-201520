/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IShipLogic;
import co.edu.uniandes.csw.mpcellphone.converters.ShipConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.ShipDTO;
import co.edu.uniandes.csw.mpcellphone.entities.ShipEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.ShipPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB relacionado con el comportamiento de un envio
 * @author Cindy Hernandez - cv.hernandez10
 */
@Stateless
public class ShipLogic implements IShipLogic {
 
    @Inject
    private ShipPersistence persistence; 
    
    @Override
    public int countShip() {
        return persistence.count();
    }

    /**
     * Metodo encargado de obtener las órdenes de un cliente
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<ShipDTO> getShips(Integer page, Integer maxRecords) {
        return ShipConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * Metodo encargado de obtener una orden solicitada a traves del id de esta
     * @param id
     * @return 
     */
    @Override
    public ShipDTO getShip(Long id) {
        return ShipConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * Metodo que permite realizar la creación de una orden
     * @param dto
     * @return 
     */
    @Override
    public ShipDTO createShip(ShipDTO dto) {
        ShipEntity entity = ShipConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ShipConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite actualizar la información de una orden
     * @param dto
     * @return 
     */
    @Override
    public ShipDTO updateShip(ShipDTO dto) {
        ShipEntity entity = persistence.update(ShipConverter.fullDTO2Entity(dto));
        return ShipConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite eliminar una orden
     * @param id 
     */
    @Override
    public void deleteShip(Long id) {
        persistence.delete(id);
    }
}