/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.PhotoDTO;
import co.edu.uniandes.csw.mpcellphone.entities.PhotoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.amaya11
 */
public abstract class PhotoConverter {

    private PhotoConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static PhotoDTO refEntity2DTO(PhotoEntity entity) {
        if (entity != null) {
            PhotoDTO dto = new PhotoDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setImage(entity.getImage());
            dto.setProduct(ProductConverter.refEntity2DTO(entity.getProduct()));
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
    public static PhotoDTO refDTO2Entity(PhotoDTO dto) {
        if (dto != null) {
            PhotoDTO entity = new PhotoDTO();
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
    private static PhotoDTO basicEntity2DTO(PhotoEntity entity) {
        if (entity != null) {
            PhotoDTO dto = new PhotoDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setImage(entity.getImage());
            dto.setProduct(ProductConverter.simpleEntity2DTO(entity.getProduct()));
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
    private static PhotoEntity basicDTO2Entity(PhotoDTO dto) {
        if (dto != null) {
            PhotoEntity entity = new PhotoEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setImage(dto.getImage());
            entity.setProduct(ProductConverter.refDTO2Entity(dto.getProduct()));
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
    public static PhotoDTO fullEntity2DTO(PhotoEntity entity) {
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
    public static PhotoEntity fullDTO2Entity(PhotoDTO dto) {
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
    public static List<PhotoDTO> listEntity2DTO(List<PhotoEntity> entities) {
        List<PhotoDTO> dtos = new ArrayList<PhotoDTO>();
        if (entities != null) {
            for (PhotoEntity entity : entities) {
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
    public static List<PhotoEntity> listDTO2Entity(List<PhotoDTO> dtos) {
        List<PhotoEntity> entities = new ArrayList<PhotoEntity>();
        if (dtos != null) {
            for (PhotoDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
