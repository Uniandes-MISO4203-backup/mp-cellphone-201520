package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.CartItemDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CartItemEntity;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.mpcellphone.entities.ClientEntity;

/**
 * @generated
 */
public abstract class CartItemConverter {

    /**
     * @generated
     */
    private CartItemConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static CartItemDTO refEntity2DTO(CartItemEntity entity) {
        if (entity != null) {
            CartItemDTO dto = new CartItemDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setQuantity(entity.getQuantity());

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
    public static CartItemEntity refDTO2Entity(CartItemDTO dto) {
        if (dto != null) {
            CartItemEntity entity = new CartItemEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static CartItemDTO basicEntity2DTO(CartItemEntity entity) {
        if (entity != null) {
            CartItemDTO dto = new CartItemDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setQuantity(entity.getQuantity());
            dto.setClient(ClientConverter.refEntity2DTO(entity.getClient()));
            dto.setProduct(ProductConverter.refEntity2DTO(entity.getProduct()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static CartItemEntity basicDTO2Entity(CartItemDTO dto) {
        if (dto != null) {
            CartItemEntity entity = new CartItemEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setQuantity(dto.getQuantity());
            entity.setClient(ClientConverter.refDTO2Entity(dto.getClient()));
            entity.setProduct(ProductConverter.refDTO2Entity(dto.getProduct()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static CartItemDTO fullEntity2DTO(CartItemEntity entity) {
        if (entity != null) {
            CartItemDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static CartItemEntity fullDTO2Entity(CartItemDTO dto) {
        if (dto != null) {
            CartItemEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<CartItemDTO> listEntity2DTO(List<CartItemEntity> entities) {
        List<CartItemDTO> dtos = new ArrayList<CartItemDTO>();
        if (entities != null) {
            for (CartItemEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<CartItemEntity> listDTO2Entity(List<CartItemDTO> dtos) {
        List<CartItemEntity> entities = new ArrayList<CartItemEntity>();
        if (dtos != null) {
            for (CartItemDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static CartItemEntity childDTO2Entity(CartItemDTO dto, ClientEntity parent){
        CartItemEntity entity = basicDTO2Entity(dto);
        entity.setClient(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<CartItemEntity> childListDTO2Entity(List<CartItemDTO> dtos, ClientEntity parent) {
        List<CartItemEntity> entities = new ArrayList<CartItemEntity>();
        if (dtos != null) {
            for (CartItemDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
