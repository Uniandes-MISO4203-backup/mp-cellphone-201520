package co.edu.uniandes.csw.model.tests;

import co.edu.uniandes.csw.model.entities.CartItemEntity;
import co.edu.uniandes.csw.model.persistence.CartItemPersistence;
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
public class CartItemPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(CartItemEntity.class.getPackage())
                .addPackage(CartItemPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private CartItemPersistence cartItemPersistence;

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
        em.createQuery("delete from CartItemEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<CartItemEntity> data = new ArrayList<CartItemEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CartItemEntity entity = new CartItemEntity();
            entity.setName(generateRandom(String.class));
            entity.setQuantity(generateRandom(Integer.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createCartItemTest() {
        CartItemEntity newEntity = new CartItemEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setQuantity(generateRandom(Integer.class));

        CartItemEntity result = cartItemPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CartItemEntity entity = em.find(CartItemEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getQuantity(), entity.getQuantity());
    }

    /**
     * @generated
     */
    @Test
    public void getCartItemsTest() {
        List<CartItemEntity> list = cartItemPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (CartItemEntity ent : list) {
            boolean found = false;
            for (CartItemEntity entity : data) {
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
    public void getCartItemTest() {
        CartItemEntity entity = data.get(0);
        CartItemEntity newEntity = cartItemPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getQuantity(), newEntity.getQuantity());
    }

    /**
     * @generated
     */
    @Test
    public void deleteCartItemTest() {
        CartItemEntity entity = data.get(0);
        cartItemPersistence.delete(entity.getId());
        CartItemEntity deleted = em.find(CartItemEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateCartItemTest() {
        CartItemEntity entity = data.get(0);

        CartItemEntity newEntity = new CartItemEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setQuantity(generateRandom(Integer.class));

        cartItemPersistence.update(newEntity);

        CartItemEntity resp = em.find(CartItemEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getQuantity(), resp.getQuantity());
    }

    /**
     * @generated
     */
    @Test
    public void getCartItemPaginationTest() {
        //Page 1
        List<CartItemEntity> ent1 = cartItemPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<CartItemEntity> ent2 = cartItemPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (CartItemEntity ent : ent1) {
            boolean found = false;
            for (CartItemEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (CartItemEntity ent : ent2) {
            boolean found = false;
            for (CartItemEntity entity : data) {
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
        List<CartItemEntity> cache = new ArrayList<CartItemEntity>();
        List<CartItemEntity> list = cartItemPersistence.findByName(name);

        for (CartItemEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (CartItemEntity ent : list) {
            boolean found = false;
            for (CartItemEntity cacheEntity : cache) {
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
