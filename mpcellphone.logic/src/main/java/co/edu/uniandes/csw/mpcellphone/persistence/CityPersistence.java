/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.converters.CityConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.CityDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.CityLogic;
import co.edu.uniandes.csw.mpcellphone.entities.CityEntity;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author m.amaya11
 */
@Stateless
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
    
    public List<CityDTO> getCityByState(Integer page, Integer maxRecords, Long idState) {
        Query q = em.createQuery("select u from " + entityClass.getSimpleName() + " u where u.state.id = :idS");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        return CityConverter.listEntity2DTO(q.setParameter("idS", idState).getResultList());
    }
}