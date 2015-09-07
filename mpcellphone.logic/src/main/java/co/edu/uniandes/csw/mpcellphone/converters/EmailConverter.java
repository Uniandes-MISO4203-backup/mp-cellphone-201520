/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.EmailDTO;
import co.edu.uniandes.csw.mpcellphone.entities.EmailEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g.gonzalez10
 */
public abstract class EmailConverter {
    
    private EmailConverter(){
        
    }
    
    /**
     * @param entity
     * @return
     * @generated
     */
    public static EmailDTO refEntity2DTO(EmailEntity entity) {
        if (entity != null) {
            EmailDTO dto = new EmailDTO();
            dto.setId(entity.getId());
            dto.setQuestion(entity.getQuestion());
            dto.setClient(ClientConverter.refEntity2DTO(entity.getClient()));
            dto.setProvider(ProviderConverter.refEntity2DTO(entity.getProvider()));
            dto.setDate(entity.getDate());
            dto.setProduct(ProductConverter.fullEntity2DTO(entity.getProduct()));
            
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
    public static EmailEntity refDTO2Entity(EmailDTO dto) {
        if (dto != null) {
            EmailEntity entity = new EmailEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static EmailDTO basicEntity2DTO(EmailEntity entity) {
        if (entity != null) {
            EmailDTO dto = new EmailDTO();
            dto.setId(entity.getId());
            dto.setQuestion(entity.getQuestion());
            dto.setClient(ClientConverter.refEntity2DTO(entity.getClient()));
            dto.setProvider(ProviderConverter.refEntity2DTO(entity.getProvider()));
            dto.setDate(entity.getDate());
            dto.setProduct(ProductConverter.refEntity2DTO(entity.getProduct()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static EmailEntity basicDTO2Entity(EmailDTO dto) {
        if (dto != null) {
            EmailEntity entity = new EmailEntity();
            entity.setId(dto.getId());
            entity.setQuestion(dto.getQuestion());
            entity.setClient(ClientConverter.refDTO2Entity(dto.getClient()));
            entity.setProvider(ProviderConverter.refDTO2Entity(dto.getProvider()));
            entity.setDate(dto.getDate());
            entity.setProduct(ProductConverter.fullDTO2Entity(dto.getProduct()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static EmailDTO fullEntity2DTO(EmailEntity entity) {
        if (entity != null) {
            EmailDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static EmailEntity fullDTO2Entity(EmailDTO dto) {
        if (dto != null) {
            EmailEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<EmailDTO> listEntity2DTO(List<EmailEntity> entities) {
        List<EmailDTO> dtos = new ArrayList<EmailDTO>();
        if (entities != null) {
            for (EmailEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<EmailEntity> listDTO2Entity(List<EmailDTO> dtos) {
        List<EmailEntity> entities = new ArrayList<EmailEntity>();
        if (dtos != null) {
            for (EmailDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    
}
