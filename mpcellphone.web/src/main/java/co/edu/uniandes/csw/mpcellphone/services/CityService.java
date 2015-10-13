/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.ICityLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.CityDTO;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ca.forero10
 */
@Path("/cities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CityService {
    
    @Inject private ICityLogic cityLogic;     
    @Context private HttpServletResponse response;
     
    
      /**
     * @generated
     */
    @GET
    public List<CityDTO> getCities() {        
        return cityLogic.getAllCities();
    }

    
}
