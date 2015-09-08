package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.ProductEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class ProductPersistence extends CrudPersistence<ProductEntity> {

    /**
     * @generated
     */
    public ProductPersistence() {
        this.entityClass = ProductEntity.class;
    }
    
     public List<ProductEntity> getByCellPhoneName(String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "%" + name.toUpperCase() + "%");
        return executeListNamedQuery("Product.getByCellPhoneName", params);
    }
     
     public ProductEntity getCheaperProduct (Long idProvider){
        try{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("idProvider",idProvider);
            List<ProductEntity> list = new ArrayList<ProductEntity>();
            list = executeListNamedQuery("Product.getCheaperProduct",params);
            return list.get(0);
            } catch(NoResultException e){
                return null;
            }
        }
     
     public ProductEntity getCheaperProvider (Long idCellPhone){
        try{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("idCellPhone",idCellPhone);
            List<ProductEntity> list = new ArrayList<ProductEntity>();
            list = executeListNamedQuery("Product.getCheaperProduct",params);
            return list.get(0);
            } catch(NoResultException e){
                return null;
            }
        }
}
