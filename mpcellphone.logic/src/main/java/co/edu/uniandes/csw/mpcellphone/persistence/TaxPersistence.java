package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.TaxEntity;
import javax.ejb.Stateless;

/**
 * Clase encargada de contener la comunicacion con la persistencia
 * @author Cindy Hernandez - cv.hernandez10
 */
@Stateless
public class TaxPersistence extends CrudPersistence<TaxEntity> {

    /**
     * Constructor de la clase
     */
    public TaxPersistence() {
        this.entityClass = TaxEntity.class;
    }
}
