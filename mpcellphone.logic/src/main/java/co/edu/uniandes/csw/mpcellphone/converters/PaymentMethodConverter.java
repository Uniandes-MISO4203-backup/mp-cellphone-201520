package co.edu.uniandes.csw.mpcellphone.converters;

import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.mpcellphone.dtos.PaymentMethodDTO;
import co.edu.uniandes.csw.mpcellphone.entities.PaymentMethodEntity;

/**
 * Converter para la entidad PaymentMethod
 * @author Cindy Hernandez - cv.hernandez10
 */
public abstract class PaymentMethodConverter {

    /**
     * Constructor del converter
     */
    private PaymentMethodConverter() {
    }

    /**
     * @param entity
     * @return
     */
    public static PaymentMethodDTO refEntity2DTO(PaymentMethodEntity entity) {
        if (entity != null) {
            PaymentMethodDTO dto = new PaymentMethodDTO();
            dto.setId(entity.getId());
            dto.setMethodName(entity.getMethodName());
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return
     */
    public static PaymentMethodEntity refDTO2Entity(PaymentMethodDTO dto) {
        if (dto != null) {
            PaymentMethodEntity entity = new PaymentMethodEntity();
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
    private static PaymentMethodDTO basicEntity2DTO(PaymentMethodEntity entity) {
        if (entity != null) {
            PaymentMethodDTO dto = new PaymentMethodDTO();
            dto.setId(entity.getId());
            dto.setMethodName(entity.getMethodName());
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return 
     */
    public static PaymentMethodEntity basicDTO2Entity(PaymentMethodDTO dto) {
        if (dto != null) {
            PaymentMethodEntity entity = new PaymentMethodEntity();
            entity.setId(dto.getId());
            entity.setMethodName(dto.getMethodName());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @return 
     */
    public static PaymentMethodDTO fullEntity2DTO(PaymentMethodEntity entity) {
        if (entity != null) {
            return basicEntity2DTO(entity);
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return 
     */
    public static PaymentMethodEntity fullDTO2Entity(PaymentMethodDTO dto) {
        if (dto != null) { 
            return basicDTO2Entity(dto);
        } else {
            return null;
        }
    }

    /**
     * @param entities
     * @return 
     */
    public static List<PaymentMethodDTO> listEntity2DTO(List<PaymentMethodEntity> entities) {
        List<PaymentMethodDTO> dtos = new ArrayList<PaymentMethodDTO>();
        if (entities != null) {
            for (PaymentMethodEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }
}
