/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IQuestionLogic;
import co.edu.uniandes.csw.mpcellphone.converters.QuestionConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.QuestionDTO;
import co.edu.uniandes.csw.mpcellphone.entities.QuestionEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.QuestionPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author g.gonzalez10
 */
@Stateless
public class QuestionLogic implements IQuestionLogic {
    
    @Inject private QuestionPersistence persistence;

    public QuestionDTO getQuestion(Long id) {
        return QuestionConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @param dto
     * @return 
     */
    public QuestionDTO createQuestion(QuestionDTO dto) {
        QuestionEntity entity = QuestionConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return QuestionConverter.fullEntity2DTO(entity);
    }

}
