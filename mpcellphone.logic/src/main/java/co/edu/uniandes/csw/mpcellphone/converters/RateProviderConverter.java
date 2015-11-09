package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.RateProviderDTO;
import co.edu.uniandes.csw.mpcellphone.entities.RateProviderEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ca.forero10
 */
public abstract class RateProviderConverter {

    public RateProviderConverter() {
    }
    
    
     /**
     * @param entity
     * @return
     * @generated
     */
    public static RateProviderDTO refEntity2DTO(RateProviderEntity entity) {
        if (entity != null) {
            RateProviderDTO dto = new RateProviderDTO();
            dto.setId(entity.getId());
            dto.setRate(entity.getRate());          
            dto.setClient(ClientConverter.refEntity2DTO(entity.getClient()));
            dto.setProvider(ProviderConverter.refEntity2DTO(entity.getProvider()));
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
    public static RateProviderEntity refDTO2Entity(RateProviderDTO dto) {
        if (dto != null) {
            RateProviderEntity entity = new RateProviderEntity();
            entity.setId(dto.getId());
            entity.setRate(dto.getRate());
            entity.setClient(ClientConverter.refDTO2Entity(dto.getClient()));
            entity.setProvider(ProviderConverter.refDTO2Entity(dto.getProvider()));
            return entity;
        } else {
            return null;
        }
    }
    
     /**
     * @generated
     */
    private static RateProviderDTO basicEntity2DTO(RateProviderEntity entity) {
        if (entity != null) {
            RateProviderDTO dto = new RateProviderDTO();
            dto.setId(entity.getId());
            dto.setRate(entity.getRate());
            dto.setClient(ClientConverter.fullEntity2DTO(entity.getClient()));
            dto.setProvider(ProviderConverter.fullEntity2DTO(entity.getProvider()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static RateProviderEntity basicDTO2Entity(RateProviderDTO dto) {
        if (dto != null) {
            RateProviderEntity entity = new RateProviderEntity();
            entity.setId(dto.getId());
            entity.setRate(dto.getRate());
            entity.setClient(ClientConverter.fullDTO2Entity(dto.getClient()));
            entity.setProvider(ProviderConverter.fullDTO2Entity(dto.getProvider()));
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
    public static RateProviderDTO fullEntity2DTO(RateProviderEntity entity) {
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
    public static RateProviderEntity fullDTO2Entity(RateProviderDTO dto) {
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
    public static List<RateProviderDTO> listEntity2DTO(List<RateProviderEntity> entities) {
        List<RateProviderDTO> dtos = new ArrayList<RateProviderDTO>();
        if (entities != null) {
            for (RateProviderEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return 
     */
    public static List<RateProviderEntity> listDTO2Entity(List<RateProviderDTO> dtos) {
        List<RateProviderEntity> entities = new ArrayList<RateProviderEntity>();
        if (dtos != null) {
            for (RateProviderDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }    
}