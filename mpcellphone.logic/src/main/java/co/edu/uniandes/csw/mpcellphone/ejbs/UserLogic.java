/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IUserLogic;
import co.edu.uniandes.csw.mpcellphone.converters.UserConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.UserDTO;
import co.edu.uniandes.csw.mpcellphone.persistence.UserPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jb.del10
 */
@Stateless
public class UserLogic implements IUserLogic{
    
    @Inject private UserPersistence persistence;

    @Override
    public int countUsers() {
        return persistence.count();
    }
    /**
     * Metodo encargado de obtener la lista de usuarios
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<UserDTO> getUsers(Integer page, Integer maxRecords) {
        return UserConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }
    
    @Override
    public UserDTO getUserByUserName(String userName) {
        return UserConverter.refEntity2DTO(persistence.getUserByUserName(userName));
    }
}

