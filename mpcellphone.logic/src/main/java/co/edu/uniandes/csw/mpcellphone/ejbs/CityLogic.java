/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.ICityLogic;
import co.edu.uniandes.csw.mpcellphone.converters.CityConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.CityDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CityEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.CityPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author m.amaya11
 */
@Stateless
public class CityLogic implements ICityLogic {
    
    @Inject private CityPersistence persistence;

    /**
     * Metodo encargado de obtener las Ordenes de un cliente
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<CityDTO> getCities(Integer page, Integer maxRecords) {
        return CityConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }
    
    /**
     * @param id
     * @generated
     * @return
     */
    @Override
    public CityDTO getCity(Long id) {
        return CityConverter.fullEntity2DTO(persistence.find(id));
    }
    
    /**
     * @generated
     * @return
     */
    @Override
    public int countCities() {
        return persistence.count();
    }

    /**
     * @param dto
     * @return 
     */
    @Override
    public CityDTO createCity(CityDTO dto) {
        CityEntity entity = CityConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return CityConverter.fullEntity2DTO(entity);
    }
    /**
     * Metodo encargado de retornar todas las ciudades
     * @return 
     */
    @Override
    public List<CityDTO> getAllCities() {
        return CityConverter.listEntity2DTO(persistence.findAll());
    }
    
    @Override
    public List<CityDTO> getCityByState(Integer page, Integer maxRecords, Long idState) {
        return persistence.getCityByState(page, maxRecords, idState);
    }
}
