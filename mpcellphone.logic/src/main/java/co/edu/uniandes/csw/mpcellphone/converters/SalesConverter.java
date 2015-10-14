package co.edu.uniandes.csw.mpcellphone.converters;

import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.mpcellphone.dtos.SaleDTO;
import co.edu.uniandes.csw.mpcellphone.entities.SalesEntity;

/**
 * Converter para la entidad Sale
 * @author Cindy Hernandez - cv.hernandez10
 */
public abstract class SalesConverter {

    /**
     * Constructor del converter
     */
    private SalesConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static SaleDTO refEntity2DTO(SalesEntity entity) {
        if (entity != null) {
            SaleDTO dto = new SaleDTO();
            dto.setId(entity.getId());
            dto.setProductId(ProductConverter.refEntity2DTO(entity.getProductId()));
            dto.setOrderId(OrderConverter.refEntity2DTO(entity.getOrderId()));
            dto.setProviderId(ProviderConverter.refEntity2DTO(entity.getProviderId()));            
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
    public static SalesEntity refDTO2Entity(SaleDTO dto) {
        if (dto != null) {
            SalesEntity entity = new SalesEntity();
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
    private static SaleDTO basicEntity2DTO(SalesEntity entity) {
        if (entity != null) {
            SaleDTO dto = new SaleDTO();
            dto.setId(entity.getId());
            dto.setProductId(ProductConverter.refEntity2DTO(entity.getProductId()));
            dto.setOrderId(OrderConverter.refEntity2DTO(entity.getOrderId()));
            dto.setProviderId(ProviderConverter.refEntity2DTO(entity.getProviderId()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return 
     */
    private static SalesEntity basicDTO2Entity(SaleDTO dto) {
        if (dto != null) {
            SalesEntity entity = new SalesEntity();
            entity.setId(dto.getId());
            entity.setProductId(ProductConverter.refDTO2Entity(dto.getProductId()));
            entity.setOrderId(OrderConverter.refDTO2Entity(dto.getOrderId()));
            entity.setProviderId(ProviderConverter.refDTO2Entity(dto.getProviderId()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @return 
     */
    public static SaleDTO fullEntity2DTO(SalesEntity entity) {
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
    public static SalesEntity fullDTO2Entity(SaleDTO dto) {
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
    public static List<SaleDTO> listEntity2DTO(List<SalesEntity> entities) {
        List<SaleDTO> dtos = new ArrayList<SaleDTO>();
        if (entities != null) {
            for (SalesEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return 
     */
    public static List<SalesEntity> listDTO2Entity(List<SaleDTO> dtos) {
        List<SalesEntity> entities = new ArrayList<SalesEntity>();
        if (dtos != null) {
            for (SaleDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
