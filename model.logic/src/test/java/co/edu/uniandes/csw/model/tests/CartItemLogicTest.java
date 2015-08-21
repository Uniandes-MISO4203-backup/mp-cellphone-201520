package co.edu.uniandes.csw.model.tests;

import co.edu.uniandes.csw.model.ejbs.CartItemLogic;
import co.edu.uniandes.csw.model.api.ICartItemLogic;
import co.edu.uniandes.csw.model.converters.CartItemConverter;
import co.edu.uniandes.csw.model.dtos.CartItemDTO;
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
public class CartItemLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(CartItemEntity.class.getPackage())
                .addPackage(CartItemDTO.class.getPackage())
                .addPackage(CartItemConverter.class.getPackage())
                .addPackage(CartItemLogic.class.getPackage())
                .addPackage(ICartItemLogic.class.getPackage())
                .addPackage(CartItemPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ICartItemLogic cartItemLogic;

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
        CartItemDTO dto = new CartItemDTO();
        dto.setName(generateRandom(String.class));
        dto.setQuantity(generateRandom(Integer.class));

        CartItemDTO result = cartItemLogic.createCartItem(dto);

        Assert.assertNotNull(result);

        CartItemEntity entity = em.find(CartItemEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getQuantity(), entity.getQuantity());
    }

    /**
     * @generated
     */
    @Test
    public void getCartItemsTest() {
        List<CartItemDTO> list = cartItemLogic.getCartItems(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (CartItemDTO dto : list) {
            boolean found = false;
            for (CartItemEntity entity : data) {
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
    public void getCartItemTest() {
        CartItemEntity entity = data.get(0);
        CartItemDTO dto = cartItemLogic.getCartItem(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getQuantity(), dto.getQuantity());
    }

    /**
     * @generated
     */
    @Test
    public void deleteCartItemTest() {
        CartItemEntity entity = data.get(0);
        cartItemLogic.deleteCartItem(entity.getId());
        CartItemEntity deleted = em.find(CartItemEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateCartItemTest() {
        CartItemEntity entity = data.get(0);

        CartItemDTO dto = new CartItemDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setQuantity(generateRandom(Integer.class));

        cartItemLogic.updateCartItem(dto);

        CartItemEntity resp = em.find(CartItemEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getQuantity(), resp.getQuantity());
    }

    /**
     * @generated
     */
    @Test
    public void getCartItemPaginationTest() {
        //Page 1
        List<CartItemDTO> dto1 = cartItemLogic.getCartItems(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<CartItemDTO> dto2 = cartItemLogic.getCartItems(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (CartItemDTO dto : dto1) {
            boolean found = false;
            for (CartItemEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (CartItemDTO dto : dto2) {
            boolean found = false;
            for (CartItemEntity entity : data) {
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
        List<CartItemEntity> cache = new ArrayList<CartItemEntity>();
        List<CartItemDTO> list = cartItemLogic.findByName(name);

        for (CartItemEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (CartItemDTO dto : list) {
            boolean found = false;
            for (CartItemEntity cacheEntity : cache) {
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
