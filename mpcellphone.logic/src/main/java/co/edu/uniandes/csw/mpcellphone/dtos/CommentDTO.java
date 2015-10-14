package co.edu.uniandes.csw.mpcellphone.dtos;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jh.rubiano10
 */
@XmlRootElement
public class CommentDTO {
    private Long id;
    private String comment;
    private Date date;
    private Long clientId;
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }   
}