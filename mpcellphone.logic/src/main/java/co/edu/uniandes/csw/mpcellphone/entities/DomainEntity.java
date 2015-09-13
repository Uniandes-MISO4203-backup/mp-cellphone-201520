package co.edu.uniandes.csw.mpcellphone.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;

/*
 @autor jbdel10
*/

/**
 * @generated
 */
@Entity
/*
@NamedQueries({
    @NamedQuery(name = "Domain.getByEntity", query = "select u from domain u WHERE u.entity = :p_entity"),
    @NamedQuery(name = "Domain.getByDomain", query = "select u from domain u WHERE u.entity = :p_entity and u.domain_name = :p_domain"),
    @NamedQuery(name = "Domain.getById", query = "select u from domain u WHERE u.entity = :p_entity and u.domain_name = :p_domain and u.id = :p_id") 
})
*/
public class DomainEntity implements Serializable {
    
    @Id private String entityName;  //Nombre de la entidad
    @Id private String domainName;  //Nombre del dominio Ej. Tipo, Estado
    @Id private Integer id;         //Identificador del dominio    
    
    private String mainValue;       //Valor principal
    private String otherValue;      //Otro valor posible
    
    public String getEntityName() {
        return entityName;
    }
    
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    
    public String getDomainName() {
        return domainName;
    }
    
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainValue() {
        return mainValue;
    } 
    
    public void setMainValue(String mainValue) {
        this.mainValue = mainValue;
    }
    
    public String getOtherValue() {
        return otherValue;
    } 
    
    public void setOtherValue(String otherValue) {
        this.otherValue = otherValue;
    }
}
