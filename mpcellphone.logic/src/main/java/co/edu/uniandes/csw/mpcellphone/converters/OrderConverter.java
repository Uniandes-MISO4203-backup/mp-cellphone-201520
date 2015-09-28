package co.edu.uniandes.csw.mpcellphone.converters;

import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.mpcellphone.entities.ClientEntity;
import co.edu.uniandes.csw.mpcellphone.entities.OrderEntity;
import co.edu.uniandes.csw.mpcellphone.dtos.OrderDTO;

/**
 * Converter para la entidad Order
 * @author Cindy Hernandez - cv.hernandez10
 */
public abstract class OrderConverter {

    /**
     * Constructor del converter
     */
    private OrderConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static OrderDTO refEntity2DTO(OrderEntity entity) {
        if (entity != null) {
            OrderDTO dto = new OrderDTO();
            dto.setId(entity.getId());
            dto.setState(entity.getState());
            dto.setDateOrder(entity.getDateOrder());
            dto.setBank(entity.getBank());
            dto.setExpirationDate(entity.getExpirationDate());
            dto.setNumberCard(entity.getNumberCard());
            dto.setSvc(entity.getSvc());
            dto.setTotalDiscount(entity.getTotalDiscount());
            dto.setTotalSale(entity.getTotalSale());
            dto.setTotalTax(entity.getTotalTax());

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
    public static OrderEntity refDTO2Entity(OrderDTO dto) {
        if (dto != null) {
            OrderEntity entity = new OrderEntity();
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
    private static OrderDTO basicEntity2DTO(OrderEntity entity) {
        if (entity != null) {
            OrderDTO dto = new OrderDTO();
            dto.setId(entity.getId());
            dto.setShip(ShipConverter.refEntity2DTO(entity.getShip()));
            dto.setState(entity.getState());
            dto.setClient(ClientConverter.refEntity2DTO(entity.getClient()));
            dto.setDateOrder(entity.getDateOrder());
            dto.setBank(entity.getBank());
            dto.setExpirationDate(entity.getExpirationDate());
            dto.setNumberCard(entity.getNumberCard());
            dto.setSvc(entity.getSvc());
            dto.setTotalDiscount(entity.getTotalDiscount());
            dto.setTotalSale(entity.getTotalSale());
            dto.setTotalTax(entity.getTotalTax());
            dto.setPaymentMethod(PaymentMethodConverter.refEntity2DTO(entity.getPaymentMethod()));
            dto.setTax(TaxConverter.refEntity2DTO(entity.getTax()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return 
     */
    private static OrderEntity basicDTO2Entity(OrderDTO dto) {
        if (dto != null) {
            OrderEntity entity = new OrderEntity();
            entity.setId(dto.getId());
            entity.setShip(ShipConverter.refDTO2Entity(dto.getShip()));
            entity.setState(dto.getState());
            entity.setClient(ClientConverter.refDTO2Entity(dto.getClient()));
            entity.setDateOrder(dto.getDateOrder());
            entity.setBank(dto.getBank());
            entity.setExpirationDate(dto.getExpirationDate());
            entity.setNumberCard(dto.getNumberCard());
            entity.setSvc(dto.getSvc());
            entity.setTotalDiscount(dto.getTotalDiscount());
            entity.setTotalSale(dto.getTotalSale());
            entity.setTotalTax(dto.getTotalTax());
            entity.setPaymentMethod(PaymentMethodConverter.refDTO2Entity(dto.getPaymentMethod()));
            entity.setTax(TaxConverter.refDTO2Entity(dto.getTax()));
            
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entity
     * @return 
     */
    public static OrderDTO fullEntity2DTO(OrderEntity entity) {
        if (entity != null) {
            OrderDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return 
     */
    public static OrderEntity fullDTO2Entity(OrderDTO dto) {
        if (dto != null) {
            OrderEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @param entities
     * @return 
     */
    public static List<OrderDTO> listEntity2DTO(List<OrderEntity> entities) {
        List<OrderDTO> dtos = new ArrayList<OrderDTO>();
        if (entities != null) {
            for (OrderEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @param dtos
     * @return 
     */
    public static List<OrderEntity> listDTO2Entity(List<OrderDTO> dtos) {
        List<OrderEntity> entities = new ArrayList<OrderEntity>();
        if (dtos != null) {
            for (OrderDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @param dto
     * @param parent
     * @return 
     */
    public static OrderEntity childDTO2Entity(OrderDTO dto, ClientEntity parent){
        OrderEntity entity = basicDTO2Entity(dto);
        entity.setClient(parent);
        return entity;
    }

    /**
     * @param dtos
     * @param parent
     * @return 
     */
    public static List<OrderEntity> childListDTO2Entity(List<OrderDTO> dtos, ClientEntity parent) {
        List<OrderEntity> entities = new ArrayList<OrderEntity>();
        if (dtos != null) {
            for (OrderDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
