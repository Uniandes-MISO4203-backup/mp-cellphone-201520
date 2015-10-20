package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.entities.AdminEntity;
import co.edu.uniandes.csw.mpcellphone.entities.UserEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.AdminPersistence;
import co.edu.uniandes.csw.mpcellphone.persistence.UserPersistence;
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
public class AdminPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(AdminEntity.class.getPackage())
                .addPackage(AdminPersistence.class.getPackage())
                .addPackage(UserPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private AdminPersistence clientPersistence;

    /**
     * @generated
     */
    @Inject
    private UserPersistence userPersistence;

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
        em.createQuery("delete from AdminEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<AdminEntity> data = new ArrayList<AdminEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            AdminEntity entity = new AdminEntity();
            entity.setName(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createClientTest() {
        AdminEntity newEntity = new AdminEntity();
        newEntity.setName(generateRandom(String.class));
        
        UserEntity newEntityUser = new UserEntity();
        newEntityUser.setName(generateRandom(String.class));
        newEntityUser.setEmail(generateRandom(String.class));
        
        UserEntity resultUser = userPersistence.create(newEntityUser);
        newEntity.setUser(resultUser);
        
        AdminEntity result = clientPersistence.create(newEntity);

        Assert.assertNotNull(result);

        AdminEntity entity = em.find(AdminEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getEmail(), entity.getEmail());
    }

    /**
     * @generated
     */
    @Test
    public void getClientsTest() {
        List<AdminEntity> list = clientPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (AdminEntity ent : list) {
            boolean found = false;
            for (AdminEntity entity : data) {
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
    public void getClientTest() {
        AdminEntity entity = data.get(0);
        AdminEntity newEntity = clientPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getEmail(), newEntity.getEmail());
    }

    /**
     * @generated
     */
    @Test
    public void deleteClientTest() {
        AdminEntity entity = data.get(0);
        clientPersistence.delete(entity.getId());
        AdminEntity deleted = em.find(AdminEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateClientTest() {
        AdminEntity entity = data.get(0);

        AdminEntity newEntity = new AdminEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setEmail(generateRandom(String.class));

        clientPersistence.update(newEntity);

        AdminEntity resp = em.find(AdminEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getEmail(), resp.getEmail());
    }

    /**
     * @generated
     */
    @Test
    public void getClientPaginationTest() {
        //Page 1
        List<AdminEntity> ent1 = clientPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<AdminEntity> ent2 = clientPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (AdminEntity ent : ent1) {
            boolean found = false;
            for (AdminEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (AdminEntity ent : ent2) {
            boolean found = false;
            for (AdminEntity entity : data) {
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
        List<AdminEntity> cache = new ArrayList<AdminEntity>();
        List<AdminEntity> list = clientPersistence.findByName(name);

        for (AdminEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (AdminEntity ent : list) {
            boolean found = false;
            for (AdminEntity cacheEntity : cache) {
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
