/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.ITaxLogic;
import co.edu.uniandes.csw.mpcellphone.converters.TaxConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.TaxDTO;
import co.edu.uniandes.csw.mpcellphone.entities.TaxEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.TaxPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB relacionado con el comportamiento de un envio
 * @author Cindy Hernández - cv.hernandez10
 */
@Stateless
public class TaxLogic implements ITaxLogic {
 
    @Inject
    private TaxPersistence persistence; 
    
    public int countTax() {
        return persistence.count();
    }

    /**
     * Metodo encargado de obtener las órdenes de un cliente
     * @param page
     * @param maxRecords
     * @return 
     */
    public List<TaxDTO> getTaxs(Integer page, Integer maxRecords) {
        return TaxConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * Metodo encargado de obtener una orden solicitada a traves del id de esta
     * @param id
     * @return 
     */
    public TaxDTO getTax(Long id) {
        return TaxConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * Metodo que permite realizar la creación de una orden
     * @param dto
     * @return 
     */
    public TaxDTO createTax(TaxDTO dto) {
        TaxEntity entity = TaxConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return TaxConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite actualizar la información de una orden
     * @param dto
     * @return 
     */
    public TaxDTO updateTax(TaxDTO dto) {
        TaxEntity entity = persistence.update(TaxConverter.fullDTO2Entity(dto));
        return TaxConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite eliminar una orden
     * @param id 
     */
    public void deleteTax(Long id) {
        persistence.delete(id);
    }
}