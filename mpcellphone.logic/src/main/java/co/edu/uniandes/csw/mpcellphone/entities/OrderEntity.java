/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidad relacionada con la tabla que almacena la orden de una compra
 * @author Cindy Hernández - cv.hernandez10
 */
@Entity
public class OrderEntity {
    
    @Id
    @GeneratedValue(generator = "Order")
    private Long id;
    
    @ManyToOne
    private ClientEntity client;
    @ManyToOne
    private ShipEntity ship;
    
    private String state;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public ShipEntity getShip() {
        return ship;
    }

    public void setShip(ShipEntity ship) {
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
