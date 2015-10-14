/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.ejbs.CityLogic;
import co.edu.uniandes.csw.mpcellphone.entities.CityEntity;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        } catch (NoResultException ex) {
            Logger.getLogger(CityLogic.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.emptyList();
        }
    }
}