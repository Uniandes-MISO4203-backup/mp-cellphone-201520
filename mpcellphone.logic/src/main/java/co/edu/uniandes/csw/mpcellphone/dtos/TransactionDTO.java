/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.dtos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DTO de la entidad de transaction
 * @author Cindy Hernandez - cv.hernandez10
 */
@XmlRootElement
public class TransactionDTO {
 
    private Long id;
    private OrderDTO order;
    private PaymentMethodDTO paymentMethod;
    private TaxDTO tax;
    private Long totalSale;
    private Long totalDiscount;
    private Long totalTax;
    private Date payDate;
    private Long numberCard;
    private String bank;
    private String expirationDate;
    private Long svc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
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

    public Long getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(Long totalSale) {
        this.totalSale = totalSale;
    }

    public Long getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Long totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Long getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Long totalTax) {
        this.totalTax = totalTax;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(Long numberCard) {
        this.numberCard = numberCard;
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
