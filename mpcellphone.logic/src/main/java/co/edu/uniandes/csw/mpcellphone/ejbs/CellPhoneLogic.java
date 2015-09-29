package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.ICellPhoneLogic;
import co.edu.uniandes.csw.mpcellphone.converters.CellPhoneConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.CellPhoneDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CellPhoneEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.CellPhonePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class CellPhoneLogic implements ICellPhoneLogic {

    @Inject private CellPhonePersistence persistence;

    /**
     * @generated
     */
    @Override
    public int countCellPhones() {
        return persistence.count();
    }

    /**
     * @generated
     */
    @Override
    public List<CellPhoneDTO> getCellPhones(Integer page, Integer maxRecords) {
        return CellPhoneConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    @Override
    public CellPhoneDTO getCellPhone(Long id) {
        return CellPhoneConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    @Override
    public CellPhoneDTO createCellPhone(CellPhoneDTO dto) {
        CellPhoneEntity entity = CellPhoneConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return CellPhoneConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public CellPhoneDTO updateCellPhone(CellPhoneDTO dto) {
        CellPhoneEntity entity = persistence.update(CellPhoneConverter.fullDTO2Entity(dto));
        return CellPhoneConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    @Override
    public void deleteCellPhone(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    @Override
    public List<CellPhoneDTO> findByName(String name) {
        return CellPhoneConverter.listEntity2DTO(persistence.findByName(name));
    }
    
    //Para Obtener la lista de Modelos, desarrollado por Miguel Olivares
    @Override
    public List<CellPhoneDTO> getCellPhoneModel(){
        return CellPhoneConverter.listString2DTO(persistence.getCellPhoneModel());
        
    }
    //Para Obtener la lista de Marcas, desarrollado por Miguel Olivares
    @Override
    public List<CellPhoneDTO> getCellPhoneBrand(){
        return CellPhoneConverter.listString2DTO(persistence.getCellPhoneBrand());
        
    }
}
