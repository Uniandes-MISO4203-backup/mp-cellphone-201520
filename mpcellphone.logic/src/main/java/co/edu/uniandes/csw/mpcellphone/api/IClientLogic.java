package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import java.util.List;

public interface IClientLogic {
    public int countClients();
    public List<ClientDTO> getClients(Integer page, Integer maxRecords);
    public ClientDTO getClient(Long id);
    public ClientDTO createClient(ClientDTO dto);
    public ClientDTO updateClient(ClientDTO dto);
    public void deleteClient(Long id);
    public List<ClientDTO> findByName(String name);
    public ClientDTO getClientByUserId(String userId);
    public ClientDTO getClientByEmail(String email);
}
