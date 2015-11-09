package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IRateProductLogic;
import co.edu.uniandes.csw.mpcellphone.converters.RateProductConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.RateProductDTO;
import co.edu.uniandes.csw.mpcellphone.entities.RateProductEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.RateProductPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ca.forero10
 */
public class RateProductLogic implements IRateProductLogic{
    
    @Inject
    private RateProductPersistence persistence; 

    public RateProductDTO createRate(RateProductDTO dto) {
        RateProductEntity entity = RateProductConverter.refDTO2Entity(dto);
        persistence.create(entity);
        return RateProductConverter.refEntity2DTO(entity);
    }

    public RateProductDTO updateRate(RateProductDTO dto) {
        return RateProductConverter.refEntity2DTO(persistence.update(RateProductConverter.refDTO2Entity(dto)));
    }

    public RateProductDTO getRateByProductClient(Long productId, Long clientId) {
       return RateProductConverter.refEntity2DTO(persistence.findByProductClient(productId, clientId));
    }

    public List<Integer> getRateByProduct(Long productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
