/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

import co.edu.uniandes.csw.mpcellphone.dtos.PhotoDTO;
import java.util.List;

/**
 *
 * @author m.amaya11
 */
public interface IPhotoLogic {
    public int countPhotos();
    public List<PhotoDTO> getPhotos(Integer page, Integer maxRecords);
    public PhotoDTO getPhoto(Long id);
    public PhotoDTO createPhoto(PhotoDTO dto);
    public PhotoDTO updatePhoto(PhotoDTO dto);
    public void deletePhoto(Long id);
    public List<PhotoDTO> getByProductId(Long id);
    
}