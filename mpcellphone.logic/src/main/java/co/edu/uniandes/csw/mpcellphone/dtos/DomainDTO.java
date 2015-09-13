package co.edu.uniandes.csw.mpcellphone.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/*
    Entidad para dominios de cada entidad (Categorias, Tipos, Estados, etc)
 @autor jbdel10
*/

/**
 * @generated
 */
@XmlRootElement 
public class DomainDTO {
    
    private String entityName;  //Nombre de la entidad
    private String domainName;  //Nombre del dominio Ej. Tipo, Estado
    private Integer id;            //Identificador del dominio    
    private String mainValue;   //Valor principal
    private String otherValue;  //Otro valor posible
    
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
