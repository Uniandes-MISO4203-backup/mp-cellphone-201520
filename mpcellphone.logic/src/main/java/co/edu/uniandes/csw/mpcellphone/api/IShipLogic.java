/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.ShipDTO;
import java.util.List;

/**
 * Interfaz del EJB 
 * @author Cindy Hernandez - cv.hernandez10
 */
public interface IShipLogic {
    public int countShip();
    public List<ShipDTO> getShips(Integer page, Integer maxRecords);
    public ShipDTO getShip(Long id);
    public ShipDTO createShip(ShipDTO dto);
    public ShipDTO updateShip(ShipDTO dto);
    public void deleteShip(Long id);
}
