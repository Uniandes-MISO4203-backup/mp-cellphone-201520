package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IRateProviderLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.RateProviderDTO;
import java.util.List;

/**
 *
 * @author ca.forero10
 */
public class RateProviderLogic implements IRateProviderLogic{

    public RateProviderDTO createRate(RateProviderDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RateProviderDTO updateRate(Long id, int rate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RateProviderDTO getRate(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RateProviderDTO getRateByProviderClient(Long providerId, Long clientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Integer> getRateByProvider(Long providerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
