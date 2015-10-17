package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.dtos.OrderQueryDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.SaleLogic;
import co.edu.uniandes.csw.mpcellphone.entities.SalesEntity;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

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

    public List<OrderQueryDTO> getSaleByClient(Long userId){
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("client_id", userId);
            return this.executeListNamedQuery("Sales.getSaleByClient", params);
        } catch (NoResultException ex) {
            Logger.getLogger(SaleLogic.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.emptyList();
        }
    }

        public List<OrderQueryDTO> getSaleByProvider(Long userId){
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("provider_id", userId);
            return this.executeListNamedQuery("Sales.getSaleByProvider", params);
        } catch (NoResultException ex) {
            Logger.getLogger(SaleLogic.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.emptyList();
        }
    }

}
