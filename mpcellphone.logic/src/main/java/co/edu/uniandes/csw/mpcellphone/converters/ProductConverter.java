package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.ProductDTO;
import co.edu.uniandes.csw.mpcellphone.entities.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.mpcellphone.entities.ProviderEntity;

/**
 * @generated
 */
public abstract class ProductConverter {

    /**
     * @generated
     */
    private ProductConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ProductDTO refEntity2DTO(ProductEntity entity) {
        if (entity != null) {
            ProductDTO dto = new ProductDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setCellPhone(CellPhoneConverter.refEntity2DTO(entity.getCellPhone()));

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
    public static ProductEntity refDTO2Entity(ProductDTO dto) {
        if (dto != null) {
            ProductEntity entity = new ProductEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ProductDTO basicEntity2DTO(ProductEntity entity) {
        if (entity != null) {
            ProductDTO dto = new ProductDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setCellPhone(CellPhoneConverter.refEntity2DTO(entity.getCellPhone()));
            dto.setProvider(ProviderConverter.refEntity2DTO(entity.getProvider()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ProductEntity basicDTO2Entity(ProductDTO dto) {
        if (dto != null) {
            ProductEntity entity = new ProductEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setPrice(dto.getPrice());
            entity.setCellPhone(CellPhoneConverter.refDTO2Entity(dto.getCellPhone()));
            entity.setProvider(ProviderConverter.refDTO2Entity(dto.getProvider()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ProductDTO fullEntity2DTO(ProductEntity entity) {
        if (entity != null) {
            ProductDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ProductEntity fullDTO2Entity(ProductDTO dto) {
        if (dto != null) {
            ProductEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<ProductDTO> listEntity2DTO(List<ProductEntity> entities) {
        List<ProductDTO> dtos = new ArrayList<ProductDTO>();
        if (entities != null) {
            for (ProductEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<ProductEntity> listDTO2Entity(List<ProductDTO> dtos) {
        List<ProductEntity> entities = new ArrayList<ProductEntity>();
        if (dtos != null) {
            for (ProductDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static ProductEntity childDTO2Entity(ProductDTO dto, ProviderEntity parent){
        ProductEntity entity = basicDTO2Entity(dto);
        entity.setProvider(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<ProductEntity> childListDTO2Entity(List<ProductDTO> dtos, ProviderEntity parent) {
        List<ProductEntity> entities = new ArrayList<ProductEntity>();
        if (dtos != null) {
            for (ProductDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
