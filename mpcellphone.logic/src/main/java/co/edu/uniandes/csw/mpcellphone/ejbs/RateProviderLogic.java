package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IRateProviderLogic;
import co.edu.uniandes.csw.mpcellphone.converters.RateProviderConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.RateProviderDTO;
import co.edu.uniandes.csw.mpcellphone.entities.RateProviderEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.RateProviderPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ca.forero10
 */
public class RateProviderLogic implements IRateProviderLogic{
    
    @Inject
    private RateProviderPersistence persistence; 

    @Override
    public RateProviderDTO createRate(RateProviderDTO dto) {
        RateProviderEntity entity = RateProviderConverter.refDTO2Entity(dto);
        persistence.create(entity);
        return RateProviderConverter.refEntity2DTO(entity);
    }

    @Override
    public RateProviderDTO updateRate(RateProviderDTO dto) {
        return RateProviderConverter.refEntity2DTO(persistence.update(RateProviderConverter.refDTO2Entity(dto)));
    }

    @Override
    public RateProviderDTO getRateByProviderClient(Long providerId, Long clientId) {
        return RateProviderConverter.refEntity2DTO(persistence.findByProviderClient(providerId, clientId));
    }

    @Override
    public List<Integer> getRateByProvider(Long providerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
