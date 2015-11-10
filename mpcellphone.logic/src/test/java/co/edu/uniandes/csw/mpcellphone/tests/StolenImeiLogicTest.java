package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.IStolenImeiLogic;
import co.edu.uniandes.csw.mpcellphone.converters.StolenImeiConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.StolenImeiDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.StolenImeiLogic;
import co.edu.uniandes.csw.mpcellphone.entities.StolenImeiEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.StolenImeiPersistence;
import static co.edu.uniandes.csw.mpcellphone.tests._TestUtil.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class StolenImeiLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(StolenImeiEntity.class.getPackage())
                .addPackage(StolenImeiDTO.class.getPackage())
                .addPackage(StolenImeiConverter.class.getPackage())
                .addPackage(StolenImeiLogic.class.getPackage())
                .addPackage(IStolenImeiLogic.class.getPackage())
                .addPackage(StolenImeiPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IStolenImeiLogic stolenImeiLogic;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from StolenImeiEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<StolenImeiEntity> data = new ArrayList<StolenImeiEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            StolenImeiEntity entity= new StolenImeiEntity();
            entity.setImei(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void getByImeiTest() {
        
        StolenImeiEntity entity = data.get(0);
        StolenImeiDTO stolenImeiEntity = stolenImeiLogic.getByImei(entity.getImei());
        
        Assert.assertEquals(entity.getId(), stolenImeiEntity.getId());
        Assert.assertEquals(entity.getImei(), stolenImeiEntity.getImei());
        
        
    }
    
}
