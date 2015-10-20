package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.AdminDTO;
import co.edu.uniandes.csw.mpcellphone.entities.AdminEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class AdminConverter {
    
    
    /**
     * @generated
     */
    private AdminConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static AdminDTO refEntity2DTO(AdminEntity entity) {
        if (entity != null) {
            AdminDTO dto = new AdminDTO();            
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setEmail(entity.getEmail());
            //Converter para el usuario
            dto.setUser(UserConverter.refEntity2DTO(entity.getUser()));                    
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
    public static AdminEntity refDTO2Entity(AdminDTO dto) {
        if (dto != null) {
            AdminEntity entity = new AdminEntity();
            entity.setId(dto.getId());
            return entity;
        } else {
            return null;
        }
    }

    private static AdminDTO basicEntity2DTO(AdminEntity entity) {
        if (entity != null) {
            AdminDTO dto = new AdminDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setUser(UserConverter.refEntity2DTO(entity.getUser()));          
            dto.setEmail(entity.getEmail());
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static AdminEntity basicDTO2Entity(AdminDTO dto) {
        if (dto != null) {
            AdminEntity entity = new AdminEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setUser(UserConverter.refDTO2Entity(dto.getUser()));
            entity.setEmail(dto.getEmail());          
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static List<AdminDTO> listEntity2DTO(List<AdminEntity> entities) {
        List<AdminDTO> dtos = new ArrayList<AdminDTO>();
        if (entities != null) {
            for (AdminEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    public static List<AdminEntity> listDTO2Entity(List<AdminDTO> dtos) {
        List<AdminEntity> entities = new ArrayList<AdminEntity>();
        if (dtos != null) {
            for (AdminDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
