/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO referente a los datos de envio
 * @author Cindy Hernandez - cv.hernandez10
 */
@XmlRootElement
public class ShipDTO {

    private Long id;
    private String state;
    private String country;
    private String city;
    private String address;
    private Long stimatedTime;
    private ShippingTypeDTO shipType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getStimatedTime() {
        return stimatedTime;
    }

    public void setStimatedTime(Long stimatedTime) {
        this.stimatedTime = stimatedTime;
    }

    public ShippingTypeDTO getShipType() {
        return shipType;
    }

    public void setShipType(ShippingTypeDTO shipType) {
        this.shipType = shipType;
    }

}
