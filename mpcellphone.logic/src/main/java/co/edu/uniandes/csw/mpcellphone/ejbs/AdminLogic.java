package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IAdminLogic;
import co.edu.uniandes.csw.mpcellphone.converters.AdminConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.AdminDTO;
import co.edu.uniandes.csw.mpcellphone.entities.AdminEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.AdminPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class AdminLogic implements IAdminLogic {

    @Inject
    private AdminPersistence persistence;

    /**
     * @return 
     * @generated
     */
    @Override
    public int countAdmins() {
        return persistence.count();
    }

    /**
     * @param page
     * @param maxRecords
     * @return 
     * @generated
     */
    @Override
    public List<AdminDTO> getAdmins(Integer page, Integer maxRecords) {
        return AdminConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    @Override
    public AdminDTO getAdmin(Long id) {
        return AdminConverter.refEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    @Override
    public AdminDTO createAdmin(AdminDTO dto) {
        AdminEntity entity = AdminConverter.basicDTO2Entity(dto);
        persistence.create(entity);
        return AdminConverter.refEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public AdminDTO updateAdmin(AdminDTO dto) {
        AdminEntity entity = persistence.update(AdminConverter.basicDTO2Entity(dto));
        return AdminConverter.refEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public void deleteAdmin(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<AdminDTO> findByName(String name) {
        return AdminConverter.listEntity2DTO(persistence.findByName(name));
    }
    
    @Override
    public AdminDTO getAdminByUserId(String userId) {
        return AdminConverter.refEntity2DTO(persistence.getAdminByUserId(userId));
    }
}
