package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IProviderLogic;
import co.edu.uniandes.csw.mpcellphone.api.IUserLogic;
import co.edu.uniandes.csw.mpcellphone.converters.ProviderConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.ProviderDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.UserDTO;
import co.edu.uniandes.csw.mpcellphone.entities.ProviderEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.ProviderPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ProviderLogic implements IProviderLogic {

    @Inject private ProviderPersistence persistence;
    
    @Inject private IUserLogic userLogic;

    /**
     * @return 
     * @generated
     */
    @Override
    public int countProviders() {
        return persistence.count();
    }

    /**
     * @param page
     * @param maxRecords
     * @return 
     * @generated
     */
    @Override
    public List<ProviderDTO> getProviders(Integer page, Integer maxRecords) {
        return ProviderConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @param id
     * @return 
     * @generated
     */
    @Override
    public ProviderDTO getProvider(Long id) {
        return ProviderConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @param dto
     * @return 
     * @generated
     */
    @Override
    public ProviderDTO createProvider(ProviderDTO dto) {
        ProviderEntity entity = ProviderConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ProviderConverter.fullEntity2DTO(entity);
    }

    /**
     * @param dto
     * @return 
     * @generated
     */
    @Override
    public ProviderDTO updateProvider(ProviderDTO dto) {
        ProviderEntity entity = persistence.update(ProviderConverter.fullDTO2Entity(dto));
        UserDTO dtoU = userLogic.getUserByUserId(dto.getUserId());
        dtoU.setName(dto.getName());
        dtoU.setEmail(dto.getEmail());
        dtoU = userLogic.updateUser(dtoU);
        return ProviderConverter.fullEntity2DTO(entity);
    }

    /**
     * @param id
     * @generated
     */
    @Override
    public void deleteProvider(Long id) {
        persistence.delete(id);
    }

    /**
     * @param name
     * @return 
     * @generated
     */
    @Override
    public List<ProviderDTO> findByName(String name) {
        return ProviderConverter.listEntity2DTO(persistence.findByName(name));
    }
    
    /**
     * @param userId
     * @return 
     * @generated
     */
    @Override
    public ProviderDTO getProviderByUserId(String userId){
        return ProviderConverter.fullEntity2DTO(persistence.getProviderByUserId(userId));
    }

    /**
     * @param email
     * @return 
     * @generated
     */
    @Override
    public ProviderDTO getProviderByEmail(String email) {
        return ProviderConverter.refEntity2DTO(persistence.getProviderByEmail(email));
    }
    
    //Para Obtener la lista de Proveedores, desarrollado por Miguel Olivares
    @Override
    public List<ProviderDTO> getProviders(){
        return ProviderConverter.listString2DTO(persistence.getProviders());
        
    }
    
    //Para Obtener la lista de Ciudades, desarrollado por Miguel Olivares
    @Override
    public List<ProviderDTO> getCities(){
        return ProviderConverter.listString2DTO(persistence.getCities());
        
    }
}
