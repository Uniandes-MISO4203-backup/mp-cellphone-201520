/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.QuestionDTO;
import java.util.List;

/**
 *
 * @author g.gonzalez10
 */
public interface IQuestionLogic {

    public int countQuestion();
    public List<QuestionDTO> getQuestions(Integer page, Integer maxRecords);
    public List<QuestionDTO> getByProviderId(Long idProvider);
    public QuestionDTO getQuestion(Long id);
    public QuestionDTO createQuestion(QuestionDTO dto);
    public QuestionDTO updateQuestion(QuestionDTO dto);
    public void deleteQuestion(Long id);
    public List<QuestionDTO> getByFatherId(Long idProvider);
    public QuestionDTO createAnswer(QuestionDTO dto);
    
}
