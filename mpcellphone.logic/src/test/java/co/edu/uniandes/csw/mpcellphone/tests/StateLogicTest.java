package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.IStateLogic;
import co.edu.uniandes.csw.mpcellphone.converters.StateConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.StateDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.StateLogic;
import co.edu.uniandes.csw.mpcellphone.entities.StateEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.StatePersistence;
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
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class StateLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(StateEntity.class.getPackage())
                .addPackage(StateDTO.class.getPackage())
                .addPackage(StateConverter.class.getPackage())
                .addPackage(StateLogic.class.getPackage())
                .addPackage(IStateLogic.class.getPackage())
                .addPackage(StatePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IStateLogic stateLogic;

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
        em.createQuery("delete from StateEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<StateEntity> data = new ArrayList<StateEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl();                 
            StateEntity entity = StateConverter.basicDTO2Entity(
                    factory.manufacturePojo(StateDTO.class)); 
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createStateTest() {
        StateDTO dto = new StateDTO();
        dto.setName(generateRandom(String.class));

        StateDTO result = stateLogic.createState(dto);

        Assert.assertNotNull(result);

        StateEntity entity = em.find(StateEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getStatesTest() {
        List<StateDTO> list = stateLogic.getStates(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (StateDTO dto : list) {
            boolean found = false;
            for (StateEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void getStateTest() {
        StateEntity entity = data.get(0);
        StateDTO dto = stateLogic.getState(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getStatePaginationTest() {
        //Page 1
        List<StateDTO> dto1 = stateLogic.getStates(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<StateDTO> dto2 = stateLogic.getStates(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (StateDTO dto : dto1) {
            boolean found = false;
            for (StateEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (StateDTO dto : dto2) {
            boolean found = false;
            for (StateEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Test countCellphone method
     */ 
    @Test
    public void countStateTest(){
        Assert.assertEquals(data.size(), stateLogic.countStates()); 
    }
    
}
