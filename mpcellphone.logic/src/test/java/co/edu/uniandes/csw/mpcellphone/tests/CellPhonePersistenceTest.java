package co.edu.uniandes.csw.mpcellphone.tests;

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
public class CellPhonePersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(CellPhoneEntity.class.getPackage())
                .addPackage(CellPhonePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private CellPhonePersistence cellPhonePersistence;

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
            entity.setBrand(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createCellPhoneTest() {
        CellPhoneEntity newEntity = new CellPhoneEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setBrand(generateRandom(String.class));

        CellPhoneEntity result = cellPhonePersistence.create(newEntity);

        Assert.assertNotNull(result);

        CellPhoneEntity entity = em.find(CellPhoneEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getBrand(), entity.getBrand());
    }

    /**
     * @generated
     */
    @Test
    public void getCellPhonesTest() {
        List<CellPhoneEntity> list = cellPhonePersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (CellPhoneEntity ent : list) {
            boolean found = false;
            for (CellPhoneEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
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
        CellPhoneEntity newEntity = cellPhonePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getBrand(), newEntity.getBrand());
    }

    /**
     * @generated
     */
    @Test
    public void deleteCellPhoneTest() {
        CellPhoneEntity entity = data.get(0);
        cellPhonePersistence.delete(entity.getId());
        CellPhoneEntity deleted = em.find(CellPhoneEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateCellPhoneTest() {
        CellPhoneEntity entity = data.get(0);

        CellPhoneEntity newEntity = new CellPhoneEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setBrand(generateRandom(String.class));

        cellPhonePersistence.update(newEntity);

        CellPhoneEntity resp = em.find(CellPhoneEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getBrand(), resp.getBrand());
    }

    /**
     * @generated
     */
    @Test
    public void getCellPhonePaginationTest() {
        //Page 1
        List<CellPhoneEntity> ent1 = cellPhonePersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<CellPhoneEntity> ent2 = cellPhonePersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (CellPhoneEntity ent : ent1) {
            boolean found = false;
            for (CellPhoneEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (CellPhoneEntity ent : ent2) {
            boolean found = false;
            for (CellPhoneEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

}
