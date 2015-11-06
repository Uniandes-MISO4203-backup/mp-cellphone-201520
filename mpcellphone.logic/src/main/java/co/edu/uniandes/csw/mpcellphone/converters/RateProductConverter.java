package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.RateProductDTO;
import co.edu.uniandes.csw.mpcellphone.entities.RateProductEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ca.forero10
 */
public abstract class RateProductConverter {
    
    private RateProductConverter(){
    }

     /**
     * @param entity
     * @return
     * @generated
     */
    public static RateProductDTO refEntity2DTO(RateProductEntity entity) {
        if (entity != null) {
            RateProductDTO dto = new RateProductDTO();
            dto.setId(entity.getId());
            dto.setRate(entity.getRate());          
            dto.setClient(ClientConverter.refEntity2DTO(entity.getClient()));
            dto.setProduct(ProductConverter.refEntity2DTO(entity.getProduct()));
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
    public static RateProductEntity refDTO2Entity(RateProductDTO dto) {
        if (dto != null) {
            RateProductEntity entity = new RateProductEntity();
            entity.setId(dto.getId());
            return entity;
        } else {
            return null;
        }
    }
    
     /**
     * @generated
     */
    private static RateProductDTO basicEntity2DTO(RateProductEntity entity) {
        if (entity != null) {
            RateProductDTO dto = new RateProductDTO();
            dto.setId(entity.getId());
            dto.setRate(entity.getRate());
            dto.setClient(ClientConverter.fullEntity2DTO(entity.getClient()));
            dto.setProduct(ProductConverter.fullEntity2DTO(entity.getProduct()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static RateProductEntity basicDTO2Entity(RateProductDTO dto) {
        if (dto != null) {
            RateProductEntity entity = new RateProductEntity();
            entity.setId(dto.getId());
            entity.setRate(dto.getRate());
            entity.setClient(ClientConverter.fullDTO2Entity(dto.getClient()));
            entity.setProduct(ProductConverter.fullDTO2Entity(dto.getProduct()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @return 
     * @generated
     */
    public static RateProductDTO fullEntity2DTO(RateProductEntity entity) {
        if (entity != null) {
            return basicEntity2DTO(entity);
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return 
     * @generated
     */
    public static RateProductEntity fullDTO2Entity(RateProductDTO dto) {
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
    public static List<RateProductDTO> listEntity2DTO(List<RateProductEntity> entities) {
        List<RateProductDTO> dtos = new ArrayList<RateProductDTO>();
        if (entities != null) {
            for (RateProductEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return 
     */
    public static List<RateProductEntity> listDTO2Entity(List<RateProductDTO> dtos) {
        List<RateProductEntity> entities = new ArrayList<RateProductEntity>();
        if (dtos != null) {
            for (RateProductDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }    
}
