package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.RateProductDTO;
import java.util.List;

/**
 *
 * @author ca.forero10
 */
public interface IRateProductLogic {
    
    public RateProductDTO createRate(RateProductDTO dto);
    public RateProductDTO updateRate(RateProductDTO dto);
    public RateProductDTO getRate(Long id);
    public RateProductDTO getRateByProductClient(Long productId, Long clientId);
    public List<Integer> getRateByProduct(Long productId);
}
