package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.RateProviderDTO;
import java.util.List;

/**
 *
 * @author ca.forero10
 */
public interface IRateProviderLogic {
    
    public RateProviderDTO createRate(RateProviderDTO dto);
    public RateProviderDTO updateRate(RateProviderDTO dto);
    public RateProviderDTO getRate(Long id);
    public RateProviderDTO getRateByProviderClient(Long providerId, Long clientId);
    public List<Integer> getRateByProvider(Long providerId);
}
