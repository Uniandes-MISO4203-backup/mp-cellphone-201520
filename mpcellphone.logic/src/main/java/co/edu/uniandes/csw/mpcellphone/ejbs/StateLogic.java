/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IStateLogic;
import co.edu.uniandes.csw.mpcellphone.converters.StateConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.StateDTO;
import co.edu.uniandes.csw.mpcellphone.entities.StateEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.StatePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author m.amaya11
 */
@Stateless
public class StateLogic implements IStateLogic {
    
    @Inject private StatePersistence persistence;

    /**
     * Metodo encargado de obtener las Ordenes de un cliente
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<StateDTO> getStates(Integer page, Integer maxRecords) {
        return StateConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    @Override
    public StateDTO getState(Long id) {
        return StateConverter.fullEntity2DTO(persistence.find(id));
    }

    @Override
    public int countStates() {
        return persistence.count();
    }

    /**
     * @param dto
     * @return 
     */
    @Override
    public StateDTO createState(StateDTO dto) {
        StateEntity entity = StateConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return StateConverter.fullEntity2DTO(entity);
    }
}
