/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.converters.OrderConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.OrderDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.TransactionDTO;
import co.edu.uniandes.csw.mpcellphone.entities.OrderEntity;
import java.util.List;

/**
 * Interfaz del EJB 
 * @author Cindy Hernandez - cv.hernandez10
 */
public interface ITransactionLogic {
    public int countTransaction();
    public List<TransactionDTO> getTransactions(Integer page, Integer maxRecords);
    public TransactionDTO getTransaction(Long id);
    public TransactionDTO createTransaction(TransactionDTO dto);
    public TransactionDTO updateTransaction(TransactionDTO dto);
    public void deleteTransaction(Long id);
}
