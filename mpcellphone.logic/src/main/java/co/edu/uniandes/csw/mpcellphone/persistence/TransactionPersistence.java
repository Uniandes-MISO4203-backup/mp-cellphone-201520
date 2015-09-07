package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.TransactionEntity;
import javax.ejb.Stateless;

/**
 * Clase encargada de contener la comunicacion con la persistencia
 * @author Cindy Hernández - cv.hernandez10
 */
@Stateless
public class TransactionPersistence extends CrudPersistence<TransactionEntity> {

    /**
     * Constructor de la clase
     */
    public TransactionPersistence() {
        this.entityClass = TransactionEntity.class;
    }
}
