package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.entities.ClientEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class ClientConverter {
    
    /**
     * @generated
     */
    private ClientConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ClientDTO refEntity2DTO(ClientEntity entity) {
        if (entity != null) {
            ClientDTO dto = new ClientDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setUserId(entity.getUserId());
            dto.setEmail(entity.getEmail());
            dto.setGivenName(entity.getGivenName());
            dto.setSurname(entity.getSurname());
            dto.setPhone(entity.getPhone());
            dto.setAddress(entity.getAddress());
            dto.setCity(entity.getCity());
            dto.setCountry(entity.getCountry());

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
    public static ClientEntity refDTO2Entity(ClientDTO dto) {
        if (dto != null) {
            ClientEntity entity = new ClientEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ClientDTO basicEntity2DTO(ClientEntity entity) {
        if (entity != null) {
            ClientDTO dto = new ClientDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setUserId(entity.getUserId());
            dto.setEmail(entity.getEmail());
            dto.setGivenName(entity.getGivenName());
            dto.setSurname(entity.getSurname());
            dto.setPhone(entity.getPhone());
            dto.setAddress(entity.getAddress());
            dto.setCity(entity.getCity());
            dto.setCountry(entity.getCountry());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ClientEntity basicDTO2Entity(ClientDTO dto) {
        if (dto != null) {
            ClientEntity entity = new ClientEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setUserId(dto.getUserId());
            entity.setEmail(dto.getEmail());
            entity.setGivenName(dto.getGivenName());
            entity.setSurname(dto.getSurname());
            entity.setPhone(dto.getPhone());
            entity.setAddress(dto.getAddress());
            entity.setCity(dto.getCity());
            entity.setCountry(dto.getCountry());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ClientDTO fullEntity2DTO(ClientEntity entity) {
        if (entity != null) {
            ClientDTO dto = basicEntity2DTO(entity);
            dto.setShoppingCart(CartItemConverter.listEntity2DTO(entity.getShoppingCart()));
            dto.setOrder(OrderConverter.listEntity2DTO(entity.getOrder()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ClientEntity fullDTO2Entity(ClientDTO dto) {
        if (dto != null) {
            ClientEntity entity = basicDTO2Entity(dto);
            entity.setShoppingCart(CartItemConverter.childListDTO2Entity(dto.getShoppingCart(), entity));
            entity.setOrder(OrderConverter.childListDTO2Entity(dto.getOrder(), entity));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<ClientDTO> listEntity2DTO(List<ClientEntity> entities) {
        List<ClientDTO> dtos = new ArrayList<ClientDTO>();
        if (entities != null) {
            for (ClientEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<ClientEntity> listDTO2Entity(List<ClientDTO> dtos) {
        List<ClientEntity> entities = new ArrayList<ClientEntity>();
        if (dtos != null) {
            for (ClientDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
