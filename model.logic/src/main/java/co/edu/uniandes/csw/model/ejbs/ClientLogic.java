package co.edu.uniandes.csw.model.ejbs;

import co.edu.uniandes.csw.model.api.IClientLogic;
import co.edu.uniandes.csw.model.converters.ClientConverter;
import co.edu.uniandes.csw.model.dtos.ClientDTO;
import co.edu.uniandes.csw.model.entities.ClientEntity;
import co.edu.uniandes.csw.model.persistence.ClientPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ClientLogic implements IClientLogic {

    @Inject private ClientPersistence persistence;

    /**
     * @generated
     */
    public int countClients() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<ClientDTO> getClients(Integer page, Integer maxRecords) {
        return ClientConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public ClientDTO getClient(Long id) {
        return ClientConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public ClientDTO createClient(ClientDTO dto) {
        ClientEntity entity = ClientConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ClientConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public ClientDTO updateClient(ClientDTO dto) {
        ClientEntity entity = persistence.update(ClientConverter.fullDTO2Entity(dto));
        return ClientConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteClient(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<ClientDTO> findByName(String name) {
        return ClientConverter.listEntity2DTO(persistence.findByName(name));
    }
}
