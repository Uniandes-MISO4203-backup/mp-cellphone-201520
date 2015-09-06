/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.OrderDTO;
import java.util.List;

/**
 * Interfaz del EJB 
 * @author Cindy Hernandez - cv.hernandez10
 */
public interface IOrderLogic {
    public int countOrder();
    public List<OrderDTO> getOrders(Integer page, Integer maxRecords);
    public OrderDTO getOrder(Long id);
    public OrderDTO createOrder(OrderDTO dto);
    public OrderDTO updateOrder(OrderDTO dto);
    public void deleteOrder(Long id);
}
