/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.TaxDTO;
import java.util.List;

/**
 * Interfaz del EJB 
 * @author Cindy Hernandez - cv.hernandez10
 */
public interface ITaxLogic {
    public int countTax();
    public List<TaxDTO> getTaxs(Integer page, Integer maxRecords);
    public TaxDTO getTax(Long id);
    public TaxDTO createTax(TaxDTO dto);
    public TaxDTO updateTax(TaxDTO dto);
    public void deleteTax(Long id);
}
