/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.ISaleLogic;
import co.edu.uniandes.csw.mpcellphone.converters.SalesConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.SaleDTO;
import co.edu.uniandes.csw.mpcellphone.entities.SalesEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.SalePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB relacionado con el comportamiento de un envio
 * @author Cindy Hernandez - cv.hernandez10
 */
@Stateless
public class SaleLogic implements ISaleLogic {
 
    @Inject
    private SalePersistence persistence; 
    
    @Override
    public int countSale() {
        return persistence.count();
    }

    /**
     * Metodo encargado de obtener las �rdenes de un cliente
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<SaleDTO> getSales(Integer page, Integer maxRecords) {
        return SalesConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * Metodo encargado de obtener una orden solicitada a traves del id de esta
     * @param id
     * @return 
     */
    @Override
    public SaleDTO getSale(Long id) {
        return SalesConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * Metodo que permite realizar la creaci�n de una orden
     * @param dto
     * @return 
     */
    @Override
    public SaleDTO createSale(SaleDTO dto) {
        SalesEntity entity = SalesConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return SalesConverter.fullEntity2DTO(entity);
    }

    @Override
    public List<SaleDTO> getSaleByClient(Integer page, Integer maxRecords, Long userId){
        return persistence.getSaleByClient(page, maxRecords, userId);
    }
    
    @Override
    public List<SaleDTO> getSaleByProvider(Integer page, Integer maxRecords, Long userId){
        return persistence.getSaleByProvider(page, maxRecords, userId);
    }
    
    /**
     * Metodo que permite actualizar la informaci�n de una orden
     * @param dto
     * @return 
     */
    @Override
    public SaleDTO updateSale(SaleDTO dto) {
        SalesEntity entity = persistence.update(SalesConverter.fullDTO2Entity(dto));
        return SalesConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite eliminar una orden
     * @param id 
     */
    @Override
    public void deleteSale(Long id) {
        persistence.delete(id);
    }
}