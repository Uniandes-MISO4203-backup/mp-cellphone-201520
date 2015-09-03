/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author g.gonzalez10
 */
@Entity
@XmlRootElement
public class QuestionEntity implements Serializable {
    
    @Id
    @GeneratedValue(generator = "Question")
    private Long id;
    private String question;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date questionDate;
    
    @ManyToOne
    private ProductEntity product_id;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private ClientEntity user_id;
    
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

    public Date getQuestionDate() {
        return questionDate;
    }

    public void setQuestionDate(Date questionDate) {
        this.questionDate = questionDate;
    }

    public ProductEntity getProduct_id() {
        return product_id;
    }

    public void setProduct_id(ProductEntity product_id) {
        this.product_id = product_id;
    }

    public ClientEntity getUser_id() {
        return user_id;
    }

    public void setUser_id(ClientEntity user_id) {
        this.user_id = user_id;
    }
    

}
