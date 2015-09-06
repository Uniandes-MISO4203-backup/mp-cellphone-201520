/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.CommentDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CommentEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jh.rubiano10
 */
public abstract class CommentConverter {
    
    private CommentConverter(){
    }

        /**
     * @param entity
     * @return
     * @generated
     */
    public static CommentDTO refEntity2DTO(CommentEntity entity) {
        if (entity != null) {
            CommentDTO dto = new CommentDTO();
            dto.setId(entity.getId());
            dto.setComment(entity.getComment());
            dto.setDate(entity.getDate());
            dto.setProduct_id(entity.getProduct_id());
            dto.setClient_id(entity.getClient_id());

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
    public static CommentEntity refDTO2Entity(CommentDTO dto) {
        if (dto != null) {
            CommentEntity entity = new CommentEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static CommentDTO basicEntity2DTO(CommentEntity entity) {
        if (entity != null) {
            CommentDTO dto = new CommentDTO();
            dto.setId(entity.getId());
            dto.setComment(entity.getComment());
            dto.setDate(entity.getDate());
            dto.setClient_id(entity.getClient_id());
            dto.setProduct_id(entity.getProduct_id());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static CommentEntity basicDTO2Entity(CommentDTO dto) {
        if (dto != null) {
            CommentEntity entity = new CommentEntity();
            entity.setId(dto.getId());
            entity.setComment(dto.getComment());
            dto.setDate(entity.getDate());
            entity.setClient_id(dto.getClient_id());
            entity.setProduct_id(dto.getProduct_id());

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
    public static CommentDTO fullEntity2DTO(CommentEntity entity) {
        if (entity != null) {
            CommentDTO dto = basicEntity2DTO(entity);
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
    public static CommentEntity fullDTO2Entity(CommentDTO dto) {
        if (dto != null) {
            CommentEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entities
     * @return 
     */
    public static List<CommentDTO> listEntity2DTO(List<CommentEntity> entities) {
        List<CommentDTO> dtos = new ArrayList<CommentDTO>();
        if (entities != null) {
            for (CommentEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return 
     */
    public static List<CommentEntity> listDTO2Entity(List<CommentDTO> dtos) {
        List<CommentEntity> entities = new ArrayList<CommentEntity>();
        if (dtos != null) {
            for (CommentDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
    
}
