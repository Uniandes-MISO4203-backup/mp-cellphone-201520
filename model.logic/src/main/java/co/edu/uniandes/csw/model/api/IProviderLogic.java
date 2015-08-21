package co.edu.uniandes.csw.model.api;

import co.edu.uniandes.csw.model.dtos.ProviderDTO;
import java.util.List;

public interface IProviderLogic {
    public int countProviders();
    public List<ProviderDTO> getProviders(Integer page, Integer maxRecords);
    public ProviderDTO getProvider(Long id);
    public ProviderDTO createProvider(ProviderDTO dto);
    public ProviderDTO updateProvider(ProviderDTO dto);
    public void deleteProvider(Long id);
    public List<ProviderDTO> findByName(String name);
}
