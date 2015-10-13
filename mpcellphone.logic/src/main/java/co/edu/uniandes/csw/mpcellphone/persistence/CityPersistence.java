/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.CityEntity;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author m.amaya11
 */
public class CityPersistence extends CrudPersistence<CityEntity>{
    public CityPersistence(){
        this.entityClass = CityEntity.class;
    }
    
    public List<CityEntity> findAll(){
        try{
            return  executeListNamedQuery("City.getAll");
        } catch(NoResultException e){
            return null;
        }
    }
}