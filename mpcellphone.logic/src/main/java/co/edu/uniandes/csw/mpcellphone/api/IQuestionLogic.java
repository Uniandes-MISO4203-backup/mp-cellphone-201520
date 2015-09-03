/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.QuestionDTO;

/**
 *
 * @author g.gonzalez10
 */
public interface IQuestionLogic {
    public QuestionDTO getQuestion(Long id);
    public QuestionDTO createQuestion(QuestionDTO dto);
    
}
