/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IQuestionLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.QuestionDTO;
import co.edu.uniandes.csw.mpcellphone.providers.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author g.gonzalez10
 */
@Path("/questions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuestionService {
    
    @Inject 
    private IQuestionLogic questionLogic;
    @Context 
    private HttpServletResponse response;

    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;
    
    /**
     * @param dto
     * @return 
     */
    @POST
    @StatusCreated
    public QuestionDTO createQuestion(QuestionDTO dto) {
        return questionLogic.createQuestion(dto);
    }
    
    /**
     * Metodo GET, para obtener el listado de ordenes
     * @return 
     */
    @GET
    public List<QuestionDTO> getQuestions() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", questionLogic.countQuestion());
        }
        return questionLogic.getQuestions(page, maxRecords);
    }

    /**
     * Metodo GET, para obtener un dato especifico al enviar un parámetro por URL
     * @param id
     * @return 
     */
    @GET
    @Path("{id: \\d+}")
    public QuestionDTO getQuestion(@PathParam("id") Long id) {
        return questionLogic.getQuestion(id);
    }

}
