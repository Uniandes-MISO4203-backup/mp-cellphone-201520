/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.dtos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO para la entidad Order
 * @author Cindy Hernandez - cv.hernandez10
 */
@XmlRootElement
public class OrderDTO {
    
    private Long id;
    private ClientDTO client;    
    private ShipDTO ship;    
    private String state;    
    private Date dateOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public ShipDTO getShip() {
        return ship;
    }

    public void setShip(ShipDTO ship) {
        this.ship = ship;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }   
}
