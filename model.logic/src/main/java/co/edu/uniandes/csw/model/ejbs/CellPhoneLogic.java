package co.edu.uniandes.csw.model.ejbs;

import co.edu.uniandes.csw.model.api.ICellPhoneLogic;
import co.edu.uniandes.csw.model.converters.CellPhoneConverter;
import co.edu.uniandes.csw.model.dtos.CellPhoneDTO;
import co.edu.uniandes.csw.model.entities.CellPhoneEntity;
import co.edu.uniandes.csw.model.persistence.CellPhonePersistence;
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
    public int countCellPhones() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<CellPhoneDTO> getCellPhones(Integer page, Integer maxRecords) {
        return CellPhoneConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public CellPhoneDTO getCellPhone(Long id) {
        return CellPhoneConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public CellPhoneDTO createCellPhone(CellPhoneDTO dto) {
        CellPhoneEntity entity = CellPhoneConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return CellPhoneConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public CellPhoneDTO updateCellPhone(CellPhoneDTO dto) {
        CellPhoneEntity entity = persistence.update(CellPhoneConverter.fullDTO2Entity(dto));
        return CellPhoneConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteCellPhone(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<CellPhoneDTO> findByName(String name) {
        return CellPhoneConverter.listEntity2DTO(persistence.findByName(name));
    }
}
