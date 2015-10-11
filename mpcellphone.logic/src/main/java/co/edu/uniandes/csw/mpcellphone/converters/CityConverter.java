/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.CityDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CityEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.amaya11
 */
public abstract class CityConverter {
    
    private CityConverter(){
    }

        /**
     * @param entity
     * @return
     * @generated
     */
    public static CityDTO refEntity2DTO(CityEntity entity) {
        if (entity != null) {
            CityDTO dto = new CityDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setState(StateConverter.refEntity2DTO(entity.getState()));

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
    public static CityDTO refDTO2Entity(CityDTO dto) {
        if (dto != null) {
            CityDTO entity = new CityDTO();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @generated
     * @return
     */
    private static CityDTO basicEntity2DTO(CityEntity entity) {
        if (entity != null) {
            CityDTO dto = new CityDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setState(StateConverter.refEntity2DTO(entity.getState()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @generated
     * @return
     */
    private static CityEntity basicDTO2Entity(CityDTO dto) {
        if (dto != null) {
            CityEntity entity = new CityEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setState(StateConverter.refDTO2Entity(dto.getState()));

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
    public static CityDTO fullEntity2DTO(CityEntity entity) {
        if (entity != null) {
            CityDTO dto = basicEntity2DTO(entity);
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
    public static CityEntity fullDTO2Entity(CityDTO dto) {
        if (dto != null) {
            CityEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entities
     * @return 
     * @generated
     */
    public static List<CityDTO> listEntity2DTO(List<CityEntity> entities) {
        List<CityDTO> dtos = new ArrayList<CityDTO>();
        if (entities != null) {
            for (CityEntity entity : entities) {
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
    public static List<CityEntity> listDTO2Entity(List<CityDTO> dtos) {
        List<CityEntity> entities = new ArrayList<CityEntity>();
        if (dtos != null) {
            for (CityDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
    
}
