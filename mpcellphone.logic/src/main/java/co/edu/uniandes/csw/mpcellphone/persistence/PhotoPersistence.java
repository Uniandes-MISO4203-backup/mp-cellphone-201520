/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.PhotoEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author m.amaya11
 */
public class PhotoPersistence extends CrudPersistence<PhotoEntity>{
    public PhotoPersistence(){
        this.entityClass = PhotoEntity.class;
    }
    
    /**
     * Ejecuta consulta para obtener photos
     * @param id
     * @return 
     */
    public List<PhotoEntity> getByProductId(Long id){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return executeListNamedQuery("Photo.getByProductId", params);
    }
}