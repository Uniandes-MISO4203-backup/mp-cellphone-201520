package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.ShipEntity;
import javax.ejb.Stateless;

/**
 * Clase encargada de contener la comunicacion con la persistencia
 * @author Cindy Hernández - cv.hernandez10
 */
@Stateless
public class ShipPersistence extends CrudPersistence<ShipEntity> {

    /**
     * Constructor de la clase
     */
    public ShipPersistence() {
        this.entityClass = ShipEntity.class;
    }
}
