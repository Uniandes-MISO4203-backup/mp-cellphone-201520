/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.StateDTO;
import co.edu.uniandes.csw.mpcellphone.entities.StateEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.amaya11
 */
public abstract class StateConverter {
    
    private StateConverter(){
    }

        /**
     * @param entity
     * @return
     * @generated
     */
    public static StateDTO refEntity2DTO(StateEntity entity) {
        if (entity != null) {
            StateDTO dto = new StateDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
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
    public static StateEntity refDTO2Entity(StateDTO dto) {
        if (dto != null) {
            StateEntity entity = new StateEntity();
            entity.setId(dto.getId());
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param 
     * @return
     * @generated
     */
    private static StateDTO basicEntity2DTO(StateEntity entity) {
        if (entity != null) {
            StateDTO dto = new StateDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
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
    private static StateEntity basicDTO2Entity(StateDTO dto) {
        if (dto != null) {
            StateEntity entity = new StateEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());

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
    public static StateDTO fullEntity2DTO(StateEntity entity) {
        if (entity != null) {
            StateDTO dto = basicEntity2DTO(entity);
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
    public static StateEntity fullDTO2Entity(StateDTO dto) {
        if (dto != null) {
            StateEntity entity = basicDTO2Entity(dto);
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
    public static List<StateDTO> listEntity2DTO(List<StateEntity> entities) {
        List<StateDTO> dtos = new ArrayList<StateDTO>();
        if (entities != null) {
            for (StateEntity entity : entities) {
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
    public static List<StateEntity> listDTO2Entity(List<StateDTO> dtos) {
        List<StateEntity> entities = new ArrayList<StateEntity>();
        if (dtos != null) {
            for (StateDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
    
}
