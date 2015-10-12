package co.edu.uniandes.csw.mpcellphone.converters;

import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.mpcellphone.entities.ShipEntity;
import co.edu.uniandes.csw.mpcellphone.dtos.ShipDTO;

/**
 * Converter para la entidad Ship
 * @author Cindy Hernandez - cv.hernandez10
 */
public abstract class ShipConverter {

    /**
     * Constructor del converter
     */
    private ShipConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ShipDTO refEntity2DTO(ShipEntity entity) {
        if (entity != null) {
            ShipDTO dto = new ShipDTO();
            dto.setId(entity.getId());
            dto.setState(entity.getState());
            dto.setAddress(entity.getAddress());
            dto.setCity(entity.getCity());
            dto.setCountry(entity.getCountry());
            dto.setStimatedTime(entity.getStimatedTime());
            dto.setShipType(ShippingTypeConverter.refEntity2DTO(entity.getShipType()));
            
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
    public static ShipEntity refDTO2Entity(ShipDTO dto) {
        if (dto != null) {
            ShipEntity entity = new ShipEntity();
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
    private static ShipDTO basicEntity2DTO(ShipEntity entity) {
        if (entity != null) {
            ShipDTO dto = new ShipDTO();
            dto.setId(entity.getId());
            dto.setState(entity.getState());
            dto.setAddress(entity.getAddress());
            dto.setCity(entity.getCity());
            dto.setCountry(entity.getCountry());
            dto.setStimatedTime(entity.getStimatedTime());
            dto.setShipType(ShippingTypeConverter.refEntity2DTO(entity.getShipType()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return 
     */
    private static ShipEntity basicDTO2Entity(ShipDTO dto) {
        if (dto != null) {
            ShipEntity entity = new ShipEntity();
            entity.setId(dto.getId());
            entity.setState(dto.getState());
            entity.setAddress(dto.getAddress());
            entity.setCity(dto.getCity());
            entity.setCountry(dto.getCountry());
            entity.setStimatedTime(dto.getStimatedTime());
            entity.setShipType(ShippingTypeConverter.refDTO2Entity(dto.getShipType()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @return 
     */
    public static ShipDTO fullEntity2DTO(ShipEntity entity) {
        if (entity != null) {
            ShipDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return 
     */
    public static ShipEntity fullDTO2Entity(ShipDTO dto) {
        if (dto != null) {
            ShipEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entities
     * @return 
     */
    public static List<ShipDTO> listEntity2DTO(List<ShipEntity> entities) {
        List<ShipDTO> dtos = new ArrayList<ShipDTO>();
        if (entities != null) {
            for (ShipEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return 
     */
    public static List<ShipEntity> listDTO2Entity(List<ShipDTO> dtos) {
        List<ShipEntity> entities = new ArrayList<ShipEntity>();
        if (dtos != null) {
            for (ShipDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
