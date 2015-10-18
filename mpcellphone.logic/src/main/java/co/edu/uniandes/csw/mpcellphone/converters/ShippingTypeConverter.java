/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.ShippingTypeDTO;
import co.edu.uniandes.csw.mpcellphone.entities.ShippingTypeEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Converter para los tipos de envio
 * @author Cindy
 */
public class ShippingTypeConverter {
    /**
     * Constructor del converter
     */
    private ShippingTypeConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ShippingTypeDTO refEntity2DTO(ShippingTypeEntity entity) {
        if (entity != null) {
            ShippingTypeDTO dto = new ShippingTypeDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setValueType(entity.getValueType());

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
    public static ShippingTypeEntity refDTO2Entity(ShippingTypeDTO dto) {
        if (dto != null) {
            ShippingTypeEntity entity = new ShippingTypeEntity();
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
    private static ShippingTypeDTO basicEntity2DTO(ShippingTypeEntity entity) {
        if (entity != null) {
            ShippingTypeDTO dto = new ShippingTypeDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setValueType(entity.getValueType());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return 
     */
    public static ShippingTypeEntity basicDTO2Entity(ShippingTypeDTO dto) {
        if (dto != null) {
            ShippingTypeEntity entity = new ShippingTypeEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setValueType(dto.getValueType());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @return 
     */
    public static ShippingTypeDTO fullEntity2DTO(ShippingTypeEntity entity) {
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
    public static ShippingTypeEntity fullDTO2Entity(ShippingTypeDTO dto) {
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
    public static List<ShippingTypeDTO> listEntity2DTO(List<ShippingTypeEntity> entities) {
        List<ShippingTypeDTO> dtos = new ArrayList<ShippingTypeDTO>();
        if (entities != null) {
            for (ShippingTypeEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return 
     */
    public static List<ShippingTypeEntity> listDTO2Entity(List<ShippingTypeDTO> dtos) {
        List<ShippingTypeEntity> entities = new ArrayList<ShippingTypeEntity>();
        if (dtos != null) {
            for (ShippingTypeDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}