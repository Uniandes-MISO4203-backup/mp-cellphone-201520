package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.SalesEntity;
import javax.ejb.Stateless;

/**
 * Clase encargada de contener la comunicacion con la persistencia
 * @author Cindy Hernandez - cv.hernandez10
 */
@Stateless
public class SalePersistence extends CrudPersistence<SalesEntity> {

    /**
     * Constructor de la clase
     */
    public SalePersistence() {
        this.entityClass = SalesEntity.class;
    }
}
