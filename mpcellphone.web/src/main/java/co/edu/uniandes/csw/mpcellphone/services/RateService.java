package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IRateProductLogic;
import co.edu.uniandes.csw.mpcellphone.api.IRateProviderLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.RateProductDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.RateProviderDTO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author ca.forero10
 */
@Path("/rate")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RateService {
    
    @Inject private IRateProductLogic rateProductLogic;
    @Inject private IRateProviderLogic rateProviderLogic;
    
    private ClientDTO client = (ClientDTO) SecurityUtils.getSubject().getSession().getAttribute("Client");
    
    /**
     * Action to create a rate for a product
     * @param dto
     * @return 
     */
    @POST
    @Path("/product/")
    public RateProductDTO rateProduct(RateProductDTO dto) {
        dto.setClient(client);
        RateProductDTO pastDto = rateProductLogic.getRateByProductClient(dto.getProduct().getId(), dto.getClient().getId());
        if(pastDto.getId()!=null){
            pastDto.setRate(dto.getRate());
            return rateProductLogic.updateRate(pastDto);
        }
        return rateProductLogic.createRate(dto);
    }
    
    /**
     * Action to create a rate for a provider
     * @param dto
     * @return 
     */
    @POST
    @Path("/provider/")
    public RateProviderDTO rateProvider(RateProviderDTO dto) {
        dto.setClient(client);
        RateProviderDTO pastDto = rateProviderLogic.getRateByProviderClient(dto.getProvider().getId(), dto.getClient().getId());
        if(pastDto.getId()!=null){
            pastDto.setRate(dto.getRate());
            return rateProviderLogic.updateRate(pastDto);
        }
        return rateProviderLogic.createRate(dto);
    }
}
