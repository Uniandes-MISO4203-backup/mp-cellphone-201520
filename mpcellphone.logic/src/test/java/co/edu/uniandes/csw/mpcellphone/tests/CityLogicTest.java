package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.ICityLogic;
import co.edu.uniandes.csw.mpcellphone.converters.CityConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.CityDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.CityLogic;
import co.edu.uniandes.csw.mpcellphone.entities.CityEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.CityPersistence;
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
public class CityLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(CityEntity.class.getPackage())
                .addPackage(CityDTO.class.getPackage())
                .addPackage(CityConverter.class.getPackage())
                .addPackage(CityLogic.class.getPackage())
                .addPackage(ICityLogic.class.getPackage())
                .addPackage(CityPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ICityLogic cityLogic;

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
        em.createQuery("delete from CityEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<CityEntity> data = new ArrayList<CityEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl();                 
            CityEntity entity = CityConverter.basicDTO2Entity(
                    factory.manufacturePojo(CityDTO.class)); 
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createStateTest() {
        CityDTO dto = new CityDTO();
        dto.setName(generateRandom(String.class));

        CityDTO result = cityLogic.createCity(dto);

        Assert.assertNotNull(result);

        CityEntity entity = em.find(CityEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getStatesTest() {
        List<CityDTO> list = cityLogic.getCities(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (CityDTO dto : list) {
            boolean found = false;
            for (CityEntity entity : data) {
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
        CityEntity entity = data.get(0);
        CityDTO dto = cityLogic.getCity(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getStatePaginationTest() {
        //Page 1
        List<CityDTO> dto1 = cityLogic.getCities(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<CityDTO> dto2 = cityLogic.getCities(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (CityDTO dto : dto1) {
            boolean found = false;
            for (CityEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (CityDTO dto : dto2) {
            boolean found = false;
            for (CityEntity entity : data) {
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
        Assert.assertEquals(data.size(), cityLogic.countCities()); 
    }
    
}
