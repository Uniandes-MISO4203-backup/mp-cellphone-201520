package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IRateProductLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.RateProductDTO;
import java.util.List;

/**
 *
 * @author ca.forero10
 */
public class RateProductLogic implements IRateProductLogic{

    public RateProductDTO createRate(RateProductDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RateProductDTO updateRate(Long id, int rate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RateProductDTO getRate(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RateProductDTO getRateByProductClient(Long productId, Long clientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Integer> getRateByProduct(Long productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
