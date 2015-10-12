package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.ShippingTypeEntity;
import javax.ejb.Stateless;

/**
 * Clase encargada de contener la comunicacion con la persistencia
 * @author Cindy Hernandez - cv.hernandez10
 */
@Stateless
public class ShippingTypePersistence extends CrudPersistence<ShippingTypeEntity> {

    /**
     * Constructor de la clase
     */
    public ShippingTypePersistence() {
        this.entityClass = ShippingTypeEntity.class;
    }
}
