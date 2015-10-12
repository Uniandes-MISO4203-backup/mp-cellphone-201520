package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.CellPhoneEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class CellPhonePersistence extends CrudPersistence<CellPhoneEntity> {

    /**
     * @generated
     */
    public CellPhonePersistence() {
        this.entityClass = CellPhoneEntity.class;
    }
 
    //Para Obtener la lista de Modelos desarrollado por Miguel Olivares
    public List<String> getCellPhoneModel() {
        try{
            
            List<String> list = new ArrayList<String>();
            list = executeListNamedQuery("CellPhone.getCellPhoneModel");
            
            return list;
            } catch(NoResultException e){
                return null;
                
            }
    }
    
    //Para Obtener la lista de Marcas desarrollado por Miguel Olivares
    public List<String> getCellPhoneBrand() {
        try{
            
            List<String> list = new ArrayList<String>();
            list = executeListNamedQuery("CellPhone.getCellPhoneBrand");
            
            return list;
            } catch(NoResultException e){
                return null;
                
            }
    }
    
    
}
