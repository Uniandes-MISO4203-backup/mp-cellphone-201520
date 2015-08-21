package co.edu.uniandes.csw.model.persistence;

import co.edu.uniandes.csw.model.entities.ProductEntity;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class ProductPersistence extends CrudPersistence<ProductEntity> {

    /**
     * @generated
     */
    public ProductPersistence() {
        this.entityClass = ProductEntity.class;
    }
}
