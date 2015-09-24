package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IClientLogic;
import co.edu.uniandes.csw.mpcellphone.converters.ClientConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.entities.ClientEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.ClientPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ClientLogic implements IClientLogic {

    @Inject
    private ClientPersistence persistence;

    /**
     * @return 
     * @generated
     */
    @Override
    public int countClients() {
        return persistence.count();
    }

    /**
     * @param page
     * @param maxRecords
     * @return 
     * @generated
     */
    @Override
    public List<ClientDTO> getClients(Integer page, Integer maxRecords) {
        return ClientConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @param id
     * @return 
     * @generated
     */
    @Override
    public ClientDTO getClient(Long id) {
        return ClientConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @param dto
     * @return 
     * @generated
     */
    @Override
    public ClientDTO createClient(ClientDTO dto) {
        ClientEntity entity = ClientConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ClientConverter.fullEntity2DTO(entity);
    }

    /**
     * @param dto
     * @return 
     * @generated
     */
    @Override
    public ClientDTO updateClient(ClientDTO dto) {
        ClientEntity entity = persistence.update(ClientConverter.fullDTO2Entity(dto));
        return ClientConverter.fullEntity2DTO(entity);
    }

    /**
     * @param id
     * @generated
     */
    @Override
    public void deleteClient(Long id) {
        persistence.delete(id);
    }

    /**
     * @param name
     * @return 
     * @generated
     */
    @Override
    public List<ClientDTO> findByName(String name) {
        return ClientConverter.listEntity2DTO(persistence.findByName(name));
    }

    /**
     * @param userId
     * @return 
     * @generated
     */
    @Override
    public ClientDTO getClientByUserId(String userId) {
        return ClientConverter.refEntity2DTO(persistence.getClientByUserId(userId));
    }
    
    /**
     * @param email
     * @return 
     * @generated
     */
    public ClientDTO getClientByEmail(String email) {
        return ClientConverter.refEntity2DTO(persistence.getClientByEmail(email));
    }

}
