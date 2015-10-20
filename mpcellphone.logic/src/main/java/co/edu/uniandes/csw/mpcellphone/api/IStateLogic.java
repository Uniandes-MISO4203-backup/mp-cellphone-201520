/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.StateDTO;
import java.util.List;

/**
 *
 * @author m.amaya11
 */
public interface IStateLogic {
    public int countStates();
    public List<StateDTO> getStates(Integer page, Integer maxRecords);
    public StateDTO getState(Long id);
    public StateDTO createState(StateDTO dto);
    
}