/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IStateLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.StateDTO;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author cv.hernandez10
 */
@Path("/states")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StateService {
    
    @Inject private IStateLogic stateLogic;     
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords; 
    
      /**
     * @return 
     * @generated
     */
    @GET
    public List<StateDTO> getStates() {        
        return stateLogic.getStates(page, maxRecords);
    }    
}
