/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.converters;

import co.edu.uniandes.csw.mpcellphone.dtos.StolenImeiDTO;
import co.edu.uniandes.csw.mpcellphone.entities.StolenImeiEntity;

/**
 * 
 * @author ca.forero10
 */
public abstract class StolenImeiConverter {
    
    private StolenImeiConverter(){
        
    }
    
    /**
     * 
     * @param entity
     * @return 
     */
    public static StolenImeiDTO basicEntity2DTO(StolenImeiEntity entity){        
        if(entity != null){
            StolenImeiDTO dto = new StolenImeiDTO();
            dto.setId(entity.getId());
            dto.setImei(entity.getImei());
            return dto;
        }else{
            return null;
        }
    }
    
}
