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
    private PaymentMethodDTO paymentMethod;
    private TaxDTO tax;    
    private Long numberCard;    
    private String totalSale;    
    private String totalDiscount;    
    private String totalTax;    
    private String bank;    
    private String expirationDate;    
    private Long svc;

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

    public PaymentMethodDTO getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodDTO paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public TaxDTO getTax() {
        return tax;
    }

    public void setTax(TaxDTO tax) {
        this.tax = tax;
    }

    public Long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(Long numberCard) {
        this.numberCard = numberCard;
    }

    public String getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(String totalSale) {
        this.totalSale = totalSale;
    }

    public String getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getSvc() {
        return svc;
    }

    public void setSvc(Long svc) {
        this.svc = svc;
    }
    
    
}
