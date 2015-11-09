/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.CityDTO;
import java.util.List;

/**
 *
 * @author m.amaya11
 */
public interface ICityLogic {
    public int countCities();
    public List<CityDTO> getAllCities();
    public List<CityDTO> getCities(Integer page, Integer maxRecords);
    public CityDTO getCity(Long id);
    public CityDTO createCity(CityDTO dto);
    public List<CityDTO> getCityByState(Integer page, Integer maxRecords, Long idState);    
}