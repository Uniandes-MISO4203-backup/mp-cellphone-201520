/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.ICommentLogic;
import co.edu.uniandes.csw.mpcellphone.converters.CommentConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.CommentDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CommentEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.CommentPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jh.rubiano10
 */
@Stateless
public class CommentLogic implements ICommentLogic {
    
    @Inject private CommentPersistence persistence;

    /**
     * Metodo encargado de obtener las órdenes de un cliente
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<CommentDTO> getComments(Integer page, Integer maxRecords) {
        return CommentConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    @Override
    public CommentDTO getComment(Long id) {
        return CommentConverter.fullEntity2DTO(persistence.find(id));
    }

    @Override
    public int countComment() {
        return persistence.count();
    }

    /**
     * @param dto
     * @return 
     */
    @Override
    public CommentDTO createComment(CommentDTO dto) {
        CommentEntity entity = CommentConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return CommentConverter.fullEntity2DTO(entity);
    }
}
