/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.ITransactionLogic;
import co.edu.uniandes.csw.mpcellphone.converters.QuestionConverter;
import co.edu.uniandes.csw.mpcellphone.converters.TransactionConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.OrderDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.TransactionDTO;
import co.edu.uniandes.csw.mpcellphone.entities.TransactionEntity;
import co.edu.uniandes.csw.mpcellphone.pdf.GenerateFactura;
import co.edu.uniandes.csw.mpcellphone.persistence.TransactionPersistence;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB relacionado con el comportamiento de una transaccion
 * @author Cindy Hernandez - cv.hernandez10
 */
@Stateless
public class TransactionLogic implements ITransactionLogic {
 
    @Inject
    private TransactionPersistence persistence; 
    
    public int countTransaction() {
        return persistence.count();
    }

    /**
     * Metodo encargado de obtener transacciones
     * @param page
     * @param maxRecords
     * @return 
     */
    public List<TransactionDTO> getTransactions(Integer page, Integer maxRecords) {
        return TransactionConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * Metodo encargado de obtener una transaccion 
     * @param id
     * @return 
     */
    public TransactionDTO getTransaction(Long id) {
        return TransactionConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * Metodo que permite realizar la creación de una transaccion
     * @param dto
     * @param order
     * @return 
     * @throws java.io.FileNotFoundException 
     * @throws com.itextpdf.text.DocumentException 
     */
    public TransactionDTO createTransaction(TransactionDTO dto){
        TransactionEntity entity = TransactionConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        String factura = null;
        
        try {
            GenerateFactura p = new GenerateFactura();
            factura = p.generate();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //Enviar factura por email
        //Send email
        String emailMsg="<html><body><br />Señor(a) "+"Cindy"+
                "<br /><br />" +
                "Los datos de su compra son: <br /><br /> " +
                "<br />Forma de Pago: " + dto.getPaymentMethod().getMethodName()+ 
                "<br />Valor Total de la compra: " + dto.getTotalSale() + 
                "<br /><br />Atentamente," + 
                "<br /><br /><br />MarketPhone";
        String subject = "Ha recibido un mensaje de MarketPhone";
        mailUtilsMP.sendEmailMPAttach(emailMsg, "cvho31@gmail.co", subject, factura);
                
        return TransactionConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite actualizar la información de una transaccion
     * @param dto
     * @return 
     */
    public TransactionDTO updateTransaction(TransactionDTO dto) {
        TransactionEntity entity = persistence.update(TransactionConverter.fullDTO2Entity(dto));
        return TransactionConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite eliminar una transaccion
     * @param id 
     */
    public void deleteTransaction(Long id) {
        persistence.delete(id);
    }
}