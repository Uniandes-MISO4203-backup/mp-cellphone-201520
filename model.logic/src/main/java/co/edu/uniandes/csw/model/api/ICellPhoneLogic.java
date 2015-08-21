package co.edu.uniandes.csw.model.api;

import co.edu.uniandes.csw.model.dtos.CellPhoneDTO;
import java.util.List;

public interface ICellPhoneLogic {
    public int countCellPhones();
    public List<CellPhoneDTO> getCellPhones(Integer page, Integer maxRecords);
    public CellPhoneDTO getCellPhone(Long id);
    public CellPhoneDTO createCellPhone(CellPhoneDTO dto);
    public CellPhoneDTO updateCellPhone(CellPhoneDTO dto);
    public void deleteCellPhone(Long id);
    public List<CellPhoneDTO> findByName(String name);
}
