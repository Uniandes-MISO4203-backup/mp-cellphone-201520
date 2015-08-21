package co.edu.uniandes.csw.model.tests;

import co.edu.uniandes.csw.model.entities.ProviderEntity;
import co.edu.uniandes.csw.model.persistence.ProviderPersistence;
import static co.edu.uniandes.csw.model.tests._TestUtil.*;
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
public class ProviderPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ProviderEntity.class.getPackage())
                .addPackage(ProviderPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ProviderPersistence providerPersistence;

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
        em.createQuery("delete from ProviderEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ProviderEntity> data = new ArrayList<ProviderEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ProviderEntity entity = new ProviderEntity();
            entity.setName(generateRandom(String.class));
            entity.setUserId(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createProviderTest() {
        ProviderEntity newEntity = new ProviderEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setUserId(generateRandom(String.class));

        ProviderEntity result = providerPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ProviderEntity entity = em.find(ProviderEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getUserId(), entity.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getProvidersTest() {
        List<ProviderEntity> list = providerPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ProviderEntity ent : list) {
            boolean found = false;
            for (ProviderEntity entity : data) {
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
    public void getProviderTest() {
        ProviderEntity entity = data.get(0);
        ProviderEntity newEntity = providerPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getUserId(), newEntity.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void deleteProviderTest() {
        ProviderEntity entity = data.get(0);
        providerPersistence.delete(entity.getId());
        ProviderEntity deleted = em.find(ProviderEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateProviderTest() {
        ProviderEntity entity = data.get(0);

        ProviderEntity newEntity = new ProviderEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setUserId(generateRandom(String.class));

        providerPersistence.update(newEntity);

        ProviderEntity resp = em.find(ProviderEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getUserId(), resp.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getProviderPaginationTest() {
        //Page 1
        List<ProviderEntity> ent1 = providerPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<ProviderEntity> ent2 = providerPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (ProviderEntity ent : ent1) {
            boolean found = false;
            for (ProviderEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ProviderEntity ent : ent2) {
            boolean found = false;
            for (ProviderEntity entity : data) {
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
    public void findByName() {
        String name = data.get(0).getName();
        List<ProviderEntity> cache = new ArrayList<ProviderEntity>();
        List<ProviderEntity> list = providerPersistence.findByName(name);

        for (ProviderEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (ProviderEntity ent : list) {
            boolean found = false;
            for (ProviderEntity cacheEntity : cache) {
                if (cacheEntity.getName().equals(ent.getName())) {
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
