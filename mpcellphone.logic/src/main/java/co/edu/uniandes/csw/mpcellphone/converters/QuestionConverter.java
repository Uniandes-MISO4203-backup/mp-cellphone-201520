/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.QuestionDTO;
import co.edu.uniandes.csw.mpcellphone.entities.QuestionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g.gonzalez10
 */
public abstract class QuestionConverter {
    
    private QuestionConverter(){
    }

        /**
     * @param entity
     * @return
     * @generated
     */
    public static QuestionDTO refEntity2DTO(QuestionEntity entity) {
        if (entity != null) {
            QuestionDTO dto = new QuestionDTO();
            dto.setId(entity.getId());
            dto.setQuestion(entity.getQuestion());
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
    public static QuestionEntity refDTO2Entity(QuestionDTO dto) {
        if (dto != null) {
            QuestionEntity entity = new QuestionEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static QuestionDTO basicEntity2DTO(QuestionEntity entity) {
        if (entity != null) {
            QuestionDTO dto = new QuestionDTO();
            dto.setId(entity.getId());
            dto.setQuestion(entity.getQuestion());
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
    private static QuestionEntity basicDTO2Entity(QuestionDTO dto) {
        if (dto != null) {
            QuestionEntity entity = new QuestionEntity();
            entity.setId(dto.getId());
            entity.setQuestion(dto.getQuestion());
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
    public static QuestionDTO fullEntity2DTO(QuestionEntity entity) {
        if (entity != null) {
            QuestionDTO dto = basicEntity2DTO(entity);
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
    public static QuestionEntity fullDTO2Entity(QuestionDTO dto) {
        if (dto != null) {
            QuestionEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entities
     * @return 
     */
    public static List<QuestionDTO> listEntity2DTO(List<QuestionEntity> entities) {
        List<QuestionDTO> dtos = new ArrayList<QuestionDTO>();
        if (entities != null) {
            for (QuestionEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return 
     */
    public static List<QuestionEntity> listDTO2Entity(List<QuestionDTO> dtos) {
        List<QuestionEntity> entities = new ArrayList<QuestionEntity>();
        if (dtos != null) {
            for (QuestionDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
    
}
