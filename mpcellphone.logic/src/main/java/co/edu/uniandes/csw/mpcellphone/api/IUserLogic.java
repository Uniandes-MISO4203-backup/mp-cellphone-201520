/*
    @author jdelchiaro (jb.del10)
*/
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.UserDTO;
import java.util.List;

public interface IUserLogic {
    public int countUsers();
    public List<UserDTO> getUsers(Integer page, Integer maxRecords);
    /*
    public UserDTO getUser(Long id);
    public UserDTO createUser(UserDTO dto);
    public UserDTO updateUser(UserDTO dto);
    public void deleteUser(Long id);
    public List<UserDTO> findByName(String name);
    */
}
