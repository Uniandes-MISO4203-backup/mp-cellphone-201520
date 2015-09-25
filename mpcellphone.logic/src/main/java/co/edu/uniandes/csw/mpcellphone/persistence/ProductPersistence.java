package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.ProductEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
            list = executeListNamedQuery("Product.getCheaperProvider",params);
            return list.get(0);
            } catch(NoResultException e){
                return null;
            }

        }
     //Para Obtener la lista de un modelo de producto desarrollado por Miguel Olivares
    public List<ProductEntity> getByModel(String model) {
    {
        try{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("model",model);
            
            return  executeListNamedQuery("Product.getByModel", params);
            } catch(NoResultException e){
                return null;
            }
       
    }
    }
    //Para Obtener la lista de un producto filtrado por marcas desarrollado por Miguel Olivares
    public List<ProductEntity> getByBrand(String brand) {
    {
        try{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("brand",brand);
            return  executeListNamedQuery("Product.getByBrand", params);
            } catch(NoResultException e){
                return null;
            }
        }
    }
    //Para Obtener la lista de un producto filtrado por marcas desarrollado por Miguel Olivares
    public List<ProductEntity> getByProviderName(String name) {
    {
        try{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("name",name);
            return  executeListNamedQuery("Product.getByProviderName", params);
            } catch(NoResultException e){
                return null;
            }
        }
    }
    
    //Para Obtener la lista de un producto filtrado por ciudad desarrollado por Miguel Olivares
    public List<ProductEntity> getByCity(String city) {
    {
        try{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("city",city);
            return  executeListNamedQuery("Product.getByCity", params);
            } catch(NoResultException e){
                return null;
            }
        }
    }
}
