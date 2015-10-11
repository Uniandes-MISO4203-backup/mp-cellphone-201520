/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.CityEntity;

/**
 *
 * @author m.amaya11
 */
public class CityPersistence extends CrudPersistence<CityEntity>{
    public CityPersistence(){
        this.entityClass = CityEntity.class;
    }
}