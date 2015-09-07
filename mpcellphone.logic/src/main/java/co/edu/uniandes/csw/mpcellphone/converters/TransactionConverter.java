package co.edu.uniandes.csw.mpcellphone.converters;

import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.mpcellphone.entities.TransactionEntity;
import co.edu.uniandes.csw.mpcellphone.dtos.TransactionDTO;

/**
 * Converter para la entidad Transaction
 * @author Cindy Hernández - cv.hernandez10
 */
public abstract class TransactionConverter {

    /**
     * Constructor del converter
     */
    private TransactionConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static TransactionDTO refEntity2DTO(TransactionEntity entity) {
        if (entity != null) {
            TransactionDTO dto = new TransactionDTO();
            dto.setId(entity.getId());
            dto.setPayDate(entity.getPayDate());
            dto.setTotalDiscount(entity.getTotalDiscount());
            dto.setTotalSale(entity.getTotalSale());
            dto.setTotalTax(entity.getTotalSale());
            dto.setBank(entity.getBank());
            dto.setNumberCard(entity.getNumberCard());
            dto.setSvc(entity.getSvc());
            dto.setExpirationDate(entity.getExpirationDate());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return
     * @generated
     */
    public static TransactionEntity refDTO2Entity(TransactionDTO dto) {
        if (dto != null) {
            TransactionEntity entity = new TransactionEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @return 
     */
    private static TransactionDTO basicEntity2DTO(TransactionEntity entity) {
        if (entity != null) {
            TransactionDTO dto = new TransactionDTO();
            dto.setId(entity.getId());
            dto.setPayDate(entity.getPayDate());
            dto.setTotalDiscount(entity.getTotalDiscount());
            dto.setTotalSale(entity.getTotalSale());
            dto.setTotalTax(entity.getTotalSale());
            dto.setPaymentMethod(PaymentMethodConverter.refEntity2DTO(entity.getPaymentMethod()));
            dto.setTax(TaxConverter.refEntity2DTO(entity.getTax()));
            dto.setBank(entity.getBank());
            dto.setNumberCard(entity.getNumberCard());
            dto.setSvc(entity.getSvc());
            dto.setExpirationDate(entity.getExpirationDate());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return 
     */
    private static TransactionEntity basicDTO2Entity(TransactionDTO dto) {
        if (dto != null) {
            TransactionEntity entity = new TransactionEntity();
            entity.setId(dto.getId());
            entity.setPayDate(entity.getPayDate());
            entity.setTotalDiscount(entity.getTotalDiscount());
            entity.setTotalSale(entity.getTotalSale());
            entity.setTotalTax(entity.getTotalSale());
            entity.setPaymentMethod(PaymentMethodConverter.refDTO2Entity(dto.getPaymentMethod()));
            entity.setTax(TaxConverter.refDTO2Entity(dto.getTax()));
            entity.setBank(dto.getBank());
            entity.setNumberCard(dto.getNumberCard());
            entity.setSvc(dto.getSvc());
            entity.setExpirationDate(dto.getExpirationDate());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @return 
     */
    public static TransactionDTO fullEntity2DTO(TransactionEntity entity) {
        if (entity != null) {
            TransactionDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return 
     */
    public static TransactionEntity fullDTO2Entity(TransactionDTO dto) {
        if (dto != null) {
            TransactionEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entities
     * @return 
     */
    public static List<TransactionDTO> listEntity2DTO(List<TransactionEntity> entities) {
        List<TransactionDTO> dtos = new ArrayList<TransactionDTO>();
        if (entities != null) {
            for (TransactionEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return 
     */
    public static List<TransactionEntity> listDTO2Entity(List<TransactionDTO> dtos) {
        List<TransactionEntity> entities = new ArrayList<TransactionEntity>();
        if (dtos != null) {
            for (TransactionDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
