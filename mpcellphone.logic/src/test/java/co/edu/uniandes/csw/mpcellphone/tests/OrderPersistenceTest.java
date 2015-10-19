package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.IOrderLogic;
import co.edu.uniandes.csw.mpcellphone.converters.OrderConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.OrderDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.OrderLogic;
import co.edu.uniandes.csw.mpcellphone.entities.OrderEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.OrderPersistence;
import static co.edu.uniandes.csw.mpcellphone.tests._TestUtil.*;
import java.util.ArrayList;
import java.util.Date;
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
public class OrderPersistenceTest {

    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(OrderEntity.class.getPackage())
                .addPackage(OrderDTO.class.getPackage())
                .addPackage(OrderConverter.class.getPackage())
                .addPackage(OrderLogic.class.getPackage())
                .addPackage(IOrderLogic.class.getPackage())
                .addPackage(OrderPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IOrderLogic orderLogic;

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
        em.createQuery("delete from OrderEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<OrderEntity> data = new ArrayList<OrderEntity>();

    /**
     * @generated
     */
    private void insertData() {
        String bank = generateRandom(String.class);
        Date date = new Date();
        String state = generateRandom(String.class);
        Integer numbers = generateRandom(Integer.class);

        for (int i = 0; i < 3; i++) {
            OrderEntity entity = new OrderEntity();
            entity.setBank(bank);
            entity.setDateOrder(date);
            entity.setState(state);
            entity.setTotalSale(numbers.toString());
            entity.setTotalDiscount(numbers.toString());
            entity.setTotalTax(numbers.toString());
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void getOrdersTest() {
        List<OrderDTO> list = orderLogic.getOrders(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (OrderDTO dto : list) {
            boolean found = false;
            for (OrderEntity entity : data) {
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
    public void getOrderTest() {
        OrderEntity entity = data.get(0);
        OrderDTO dto = orderLogic.getOrder(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getId(), dto.getId());
    }

    /**
     * @generated
     */
    @Test
    public void getOrderPaginationTest() {
        //Page 1
        List<OrderDTO> dto1 = orderLogic.getOrders(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<OrderDTO> dto2 = orderLogic.getOrders(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (OrderDTO dto : dto1) {
            boolean found = false;
            for (OrderEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (OrderDTO dto : dto2) {
            boolean found = false;
            for (OrderEntity entity : data) {
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
    public void countOrderTest() {
        Assert.assertEquals(data.size(), orderLogic.countOrder());
    }
    
    /**
     * @generated
     */
    @Test
    public void updateOrderTest() {
        OrderEntity entity = data.get(0);
        
        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setBank(generateRandom(String.class));
        dto.setState(generateRandom(String.class));
        dto.setTotalDiscount(generateRandom(String.class));
        dto.setTotalSale(generateRandom(String.class));
        dto.setTotalTax(generateRandom(String.class));
        dto = orderLogic.updateOrder(dto);

        OrderEntity resp = em.find(OrderEntity.class, entity.getId());

        Assert.assertEquals(dto.getBank(), resp.getBank());
        Assert.assertEquals(dto.getState(), resp.getState());
        Assert.assertEquals(dto.getTotalDiscount(), resp.getTotalDiscount());
        Assert.assertEquals(dto.getTotalSale(), resp.getTotalSale());
        Assert.assertEquals(dto.getTotalTax(), resp.getTotalTax());
    }
    
    /**
     * @generated
     */
    @Test
    public void deleteProductTest() {
        OrderEntity entity = data.get(0);
        orderLogic.deleteOrder(entity.getId());
        OrderEntity deleted = em.find(OrderEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
