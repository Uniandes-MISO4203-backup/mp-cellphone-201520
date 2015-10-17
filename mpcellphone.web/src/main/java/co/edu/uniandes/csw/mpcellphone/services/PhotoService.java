/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IPhotoLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.PhotoDTO;
import co.edu.uniandes.csw.mpcellphone.providers.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author m.amaya11
 */
@Path("/photos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PhotoService {
    
    @Inject private IPhotoLogic photoLogic;     
    @QueryParam("page") private Integer page;
    @Context private HttpServletResponse response;
    @QueryParam("maxRecords") private Integer maxRecords;
     
    
    /**
     * @param dto
     * @generated
     */
    @POST
    @StatusCreated
    public PhotoDTO createPhoto(PhotoDTO dto) { 
        return photoLogic.createPhoto(dto);
    }
    
    /**
     * Metodo PUT, encargado de actualizar informacion de la photo
     *
     * @param id
     * @param dto
     * @return
     */
    @PUT
    @Path("{id: \\d+}")
    public PhotoDTO updatePhoto(@PathParam("id") Long id, PhotoDTO dto) {
        dto.setId(id);
        return photoLogic.updatePhoto(dto);
    }
    
    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePhoto(@PathParam("id") Long id) {
        photoLogic.deletePhoto(id);        
    }
    
    
    /**
     * @generated
     */
    @GET
    public List<PhotoDTO> getPhotos() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", photoLogic.countPhotos());
        }
        return photoLogic.getPhotos(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public PhotoDTO getPhoto(@PathParam("id") Long id) {
        return photoLogic.getPhoto(id);
    }

    
}
