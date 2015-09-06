/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.CommentDTO;
import java.util.List;

/**
 *
 * @author jh.rubiano10
 */
public interface ICommentLogic {
    public int countComment();
    public List<CommentDTO> getComments(Integer page, Integer maxRecords);
    public CommentDTO getComment(Long id);
    public CommentDTO createComment(CommentDTO dto);
    
}