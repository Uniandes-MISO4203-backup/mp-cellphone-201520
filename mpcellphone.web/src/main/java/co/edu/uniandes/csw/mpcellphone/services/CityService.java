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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @Context 
    private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords; 
     
    
      /**
     * @return 
     * @generated
     */
    @GET
    public List<CityDTO> getCities() {        
        return cityLogic.getAllCities();
    }
    
    /**
     * Metodo GET, para obtener la lista de ciudades de un estado seleccionado
     * @param id
     * @return 
     */
    @GET
    @Path("/state/{id: \\d+}")
    public List<CityDTO> getCityByState(@PathParam("id") Long id) {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", cityLogic.countCities());
        }
        return cityLogic.getCityByState(page, maxRecords, id);
    }
    
    /**
     * Metodo GET, para obtener un dato especifico al enviar un parametro por URL
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public CityDTO getCity(@PathParam("id") Long id) {
        return cityLogic.getCity(id);
    }
    
}
