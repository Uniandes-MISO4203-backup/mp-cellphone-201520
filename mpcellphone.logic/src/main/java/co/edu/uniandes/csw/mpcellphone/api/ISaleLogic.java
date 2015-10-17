/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.SaleDTO;
import java.util.List;

/**
 * Interfaz del EJB 
 * @author Cindy Hernandez - cv.hernandez10
 */
public interface ISaleLogic {
    public int countSale();
    public List<SaleDTO> getSales(Integer page, Integer maxRecords);
    public List<SaleDTO> getSaleByClient(Integer page, Integer maxRecords, Long userId);
    public List<SaleDTO> getSaleByProvider(Integer page, Integer maxRecords, Long userId);
    public SaleDTO getSale(Long id);
    public SaleDTO createSale(SaleDTO dto);
    public SaleDTO updateSale(SaleDTO dto);
    public void deleteSale(Long id);
}
