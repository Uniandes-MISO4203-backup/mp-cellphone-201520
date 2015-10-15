package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.CellPhoneDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CellPhoneEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class CellPhoneConverter {

    /**
     * @generated
     */
    private CellPhoneConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static CellPhoneDTO refEntity2DTO(CellPhoneEntity entity) {
        if (entity != null) {
            CellPhoneDTO dto = new CellPhoneDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setBrand(entity.getBrand());
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
    public static CellPhoneEntity refDTO2Entity(CellPhoneDTO dto) {
        if (dto != null) {
            CellPhoneEntity entity = new CellPhoneEntity();
            entity.setId(dto.getId());
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
    private static CellPhoneDTO basicEntity2DTO(CellPhoneEntity entity) {
        if (entity != null) {
            CellPhoneDTO dto = new CellPhoneDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setBrand(entity.getBrand());
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
    private static CellPhoneEntity basicDTO2Entity(CellPhoneDTO dto) {
        if (dto != null) {
            CellPhoneEntity entity = new CellPhoneEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setBrand(dto.getBrand());
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
    public static CellPhoneDTO fullEntity2DTO(CellPhoneEntity entity) {
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
    public static CellPhoneEntity fullDTO2Entity(CellPhoneDTO dto) {
        if (dto != null) {
            return basicDTO2Entity(dto);
        } else {
            return null;
        }
    }

    /**
     * @param entities 
     * @return 
     * @generated
     */
    public static List<CellPhoneDTO> listEntity2DTO(List<CellPhoneEntity> entities) {
        List<CellPhoneDTO> dtos = new ArrayList<CellPhoneDTO>();
        if (entities != null) {
            for (CellPhoneEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return
     * @generated
     */
    public static List<CellPhoneEntity> listDTO2Entity(List<CellPhoneDTO> dtos) {
        List<CellPhoneEntity> entities = new ArrayList<CellPhoneEntity>();
        if (dtos != null) {
            for (CellPhoneDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
    
    
    /**
     * @param Models
     * @return
     * Para convertir de lista de String a Lista DTO
     * 
     */
    public static List<CellPhoneDTO> listString2DTO(List<String> models) {
        List<CellPhoneDTO> dtos = new ArrayList<CellPhoneDTO>();
        if (models != null) {
            for (String name : models) {
                CellPhoneDTO dto = new CellPhoneDTO();
                //dtos.add(basicEntity2DTO(Models));
                dto.setName(name);
                dtos.add(dto);
            }
        }
        return dtos;
    }

}
