/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.dtos;

import co.edu.uniandes.csw.mp.ann.MPLoCAnn;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author g.gonzalez10
 */
@XmlRootElement
public class QuestionDTO {
    
    private Long id;
    private String question;
    private Date date;
    private ClientDTO client;
    private ProductDTO product;
    private ProviderDTO provider;
    private String state;
    private String father;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public ProviderDTO getProvider() {
        return provider;
    }

    public void setProvider(ProviderDTO provider) {
        this.provider = provider;
    }

    @MPLoCAnn(tier="Back-end", reqId="REQ-12")
    public String getState() {
        return state;
    }

    @MPLoCAnn(tier="Back-end", reqId="REQ-12")
    public void setState(String state) {
        this.state = state;
    }

    @MPLoCAnn(tier="Back-end", reqId="REQ-12")
    public String getFather() {
        return father;
    }

    @MPLoCAnn(tier="Back-end", reqId="REQ-12")
    public void setFather(String father) {
        this.father = father;
    }
    
    @MPLoCAnn(tier="Back-end", reqId="REQ-12")
    public String getStateName() {
        if(state == null){
            return "Without answer";
        }
        else{
            return "Answered";
        }
    }
    
}
