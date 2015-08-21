package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.ejbs.CellPhoneLogic;
import co.edu.uniandes.csw.mpcellphone.api.ICellPhoneLogic;
import co.edu.uniandes.csw.mpcellphone.converters.CellPhoneConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.CellPhoneDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CellPhoneEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.CellPhonePersistence;
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
public class CellPhoneLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(CellPhoneEntity.class.getPackage())
                .addPackage(CellPhoneDTO.class.getPackage())
                .addPackage(CellPhoneConverter.class.getPackage())
                .addPackage(CellPhoneLogic.class.getPackage())
                .addPackage(ICellPhoneLogic.class.getPackage())
                .addPackage(CellPhonePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ICellPhoneLogic cellPhoneLogic;

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
        em.createQuery("delete from CellPhoneEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<CellPhoneEntity> data = new ArrayList<CellPhoneEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CellPhoneEntity entity = new CellPhoneEntity();
        	entity.setName(generateRandom(String.class));
        	entity.setDescription(generateRandom(String.class));
        	entity.setModel(generateRandom(String.class));
        	entity.setImei(generateRandom(String.class));
        	entity.setBrand(generateRandom(String.class));
        	entity.setImage(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createCellPhoneTest() {
        CellPhoneDTO dto = new CellPhoneDTO();
        dto.setName(generateRandom(String.class));
        dto.setDescription(generateRandom(String.class));
        dto.setModel(generateRandom(String.class));
        dto.setImei(generateRandom(String.class));
        dto.setBrand(generateRandom(String.class));
        dto.setImage(generateRandom(String.class));

        CellPhoneDTO result = cellPhoneLogic.createCellPhone(dto);

        Assert.assertNotNull(result);

        CellPhoneEntity entity = em.find(CellPhoneEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getDescription(), entity.getDescription());
        Assert.assertEquals(dto.getModel(), entity.getModel());
        Assert.assertEquals(dto.getImei(), entity.getImei());
        Assert.assertEquals(dto.getBrand(), entity.getBrand());
        Assert.assertEquals(dto.getImage(), entity.getImage());
    }

    /**
     * @generated
     */
    @Test
    public void getCellPhonesTest() {
        List<CellPhoneDTO> list = cellPhoneLogic.getCellPhones(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (CellPhoneDTO dto : list) {
            boolean found = false;
            for (CellPhoneEntity entity : data) {
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
    public void getCellPhoneTest() {
        CellPhoneEntity entity = data.get(0);
        CellPhoneDTO dto = cellPhoneLogic.getCellPhone(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getDescription(), dto.getDescription());
        Assert.assertEquals(entity.getModel(), dto.getModel());
        Assert.assertEquals(entity.getImei(), dto.getImei());
        Assert.assertEquals(entity.getBrand(), dto.getBrand());
        Assert.assertEquals(entity.getImage(), dto.getImage());
    }

    /**
     * @generated
     */
    @Test
    public void deleteCellPhoneTest() {
        CellPhoneEntity entity = data.get(0);
        cellPhoneLogic.deleteCellPhone(entity.getId());
        CellPhoneEntity deleted = em.find(CellPhoneEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateCellPhoneTest() {
        CellPhoneEntity entity = data.get(0);

        CellPhoneDTO dto = new CellPhoneDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setDescription(generateRandom(String.class));
        dto.setModel(generateRandom(String.class));
        dto.setImei(generateRandom(String.class));
        dto.setBrand(generateRandom(String.class));
        dto.setImage(generateRandom(String.class));

        cellPhoneLogic.updateCellPhone(dto);

        CellPhoneEntity resp = em.find(CellPhoneEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getDescription(), resp.getDescription());
        Assert.assertEquals(dto.getModel(), resp.getModel());
        Assert.assertEquals(dto.getImei(), resp.getImei());
        Assert.assertEquals(dto.getBrand(), resp.getBrand());
        Assert.assertEquals(dto.getImage(), resp.getImage());
    }

    /**
     * @generated
     */
    @Test
    public void getCellPhonePaginationTest() {
        //Page 1
        List<CellPhoneDTO> dto1 = cellPhoneLogic.getCellPhones(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<CellPhoneDTO> dto2 = cellPhoneLogic.getCellPhones(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (CellPhoneDTO dto : dto1) {
            boolean found = false;
            for (CellPhoneEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (CellPhoneDTO dto : dto2) {
            boolean found = false;
            for (CellPhoneEntity entity : data) {
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
    public void findByName() {
        String name = data.get(0).getName();
        List<CellPhoneEntity> cache = new ArrayList<CellPhoneEntity>();
        List<CellPhoneDTO> list = cellPhoneLogic.findByName(name);

        for (CellPhoneEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (CellPhoneDTO dto : list) {
            boolean found = false;
            for (CellPhoneEntity cacheEntity : cache) {
                if (cacheEntity.getName().equals(dto.getName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Assert.fail();
            }
        }
    }
}
