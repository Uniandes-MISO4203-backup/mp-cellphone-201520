package co.edu.uniandes.csw.mpcellphone.converters;

import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.mpcellphone.entities.TaxEntity;
import co.edu.uniandes.csw.mpcellphone.dtos.TaxDTO;

/**
 * Converter para la entidad Tax
 * @author Cindy Hernandez - cv.hernandez10
 */
public abstract class TaxConverter {

    /**
     * Constructor del converter
     */
    private TaxConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static TaxDTO refEntity2DTO(TaxEntity entity) {
        if (entity != null) {
            TaxDTO dto = new TaxDTO();
            dto.setId(entity.getId());
            dto.setTaxName(entity.getTaxName());
            dto.setPercentage(entity.getPercentage());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @return 
     */
    private static TaxDTO basicEntity2DTO(TaxEntity entity) {
        if (entity != null) {
            TaxDTO dto = new TaxDTO();
            dto.setId(entity.getId());
            dto.setTaxName(entity.getTaxName());
            dto.setPercentage(entity.getPercentage());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return 
     */
    private static TaxEntity basicDTO2Entity(TaxDTO dto) {
        if (dto != null) {
            TaxEntity entity = new TaxEntity();
            entity.setId(dto.getId());
            dto.setTaxName(entity.getTaxName());
            dto.setPercentage(entity.getPercentage());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @return 
     */
    public static TaxDTO fullEntity2DTO(TaxEntity entity) {
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
    public static TaxEntity fullDTO2Entity(TaxDTO dto) {
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
    public static List<TaxDTO> listEntity2DTO(List<TaxEntity> entities) {
        List<TaxDTO> dtos = new ArrayList<TaxDTO>();
        if (entities != null) {
            for (TaxEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

}
