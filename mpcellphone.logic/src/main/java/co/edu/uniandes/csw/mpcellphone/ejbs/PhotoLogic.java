/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IPhotoLogic;
import co.edu.uniandes.csw.mpcellphone.converters.PhotoConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.PhotoDTO;
import co.edu.uniandes.csw.mpcellphone.entities.PhotoEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.PhotoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author m.amaya11
 */
@Stateless
public class PhotoLogic implements IPhotoLogic {

    @Inject
    private PhotoPersistence persistence;

    /**
     * Metodo encargado de obtener las Ordenes de un cliente
     *
     * @param page
     * @param maxRecords
     * @return
     */
    @Override
    public List<PhotoDTO> getPhotos(Integer page, Integer maxRecords) {
        return PhotoConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }
    
    /**
     * @param id
     * @generated
     * @return
     */
    @Override
    public PhotoDTO getPhoto(Long id) {
        return PhotoConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @return
     * @generated
     */
    @Override
    public int countPhotos() {
        return persistence.count();
    }

    /**
     * @param dto
     * @generated
     * @return
     */
    @Override
    public PhotoDTO createPhoto(PhotoDTO dto) {
        PhotoEntity entity = PhotoConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return PhotoConverter.fullEntity2DTO(entity);
    }
    

    /**
     * Metodo que permite actualizar la informaci�n de una orden
     *
     * @param dto
     * @return
     */
    @Override
    public PhotoDTO updatePhoto(PhotoDTO dto) {
        PhotoEntity entity = persistence.update(PhotoConverter.fullDTO2Entity(dto));
        return PhotoConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite eliminar una orden
     *
     * @param id
     */
    @Override
    public void deletePhoto(Long id) {
        persistence.delete(id);
    }   
    
}
