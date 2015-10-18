package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.AdminDTO;
import java.util.List;

public interface IAdminLogic {
    public int countAdmins();
    public List<AdminDTO> getAdmins(Integer page, Integer maxRecords);
    public AdminDTO getAdmin(Long id);
    public AdminDTO createAdmin(AdminDTO dto);
    public AdminDTO updateAdmin(AdminDTO dto);
    public void deleteAdmin(Long id);
    public AdminDTO getAdminByUserId(String userId);
}