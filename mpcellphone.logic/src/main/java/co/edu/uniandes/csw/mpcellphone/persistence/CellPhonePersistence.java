package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.CellPhoneEntity;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class CellPhonePersistence extends CrudPersistence<CellPhoneEntity> {

    /**
     * @generated
     */
    public CellPhonePersistence() {
        this.entityClass = CellPhoneEntity.class;
    }
}
