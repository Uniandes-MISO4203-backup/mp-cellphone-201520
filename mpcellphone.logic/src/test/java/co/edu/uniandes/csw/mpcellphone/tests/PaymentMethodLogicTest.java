package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.IPaymentMethodLogic;
import co.edu.uniandes.csw.mpcellphone.converters.PaymentMethodConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.PaymentMethodDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.PaymentMethodLogic;
import co.edu.uniandes.csw.mpcellphone.entities.PaymentMethodEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.PaymentMethodPersistence;
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
public class PaymentMethodLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PaymentMethodEntity.class.getPackage())
                .addPackage(PaymentMethodDTO.class.getPackage())
                .addPackage(PaymentMethodConverter.class.getPackage())
                .addPackage(PaymentMethodLogic.class.getPackage())
                .addPackage(IPaymentMethodLogic.class.getPackage())
                .addPackage(PaymentMethodPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IPaymentMethodLogic paymentMethodLogic;

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
        em.createQuery("delete from PaymentMethodEntity").executeUpdate();
    }
    
    
    
    /**
     * @generated
     */
    @Test
    public void updatePhotoTest() {
        PaymentMethodEntity entity = data.get(0);

        PaymentMethodDTO dto = new PaymentMethodDTO();

        dto.setId(entity.getId());
        entity.setMethodName(generateRandom(String.class));

        paymentMethodLogic.updatePaymentMethod(dto);

        PaymentMethodEntity resp = em.find(PaymentMethodEntity.class, entity.getId());

        Assert.assertEquals(dto.getMethodName(), resp.getMethodName());
    }

    /**
     * @generated
     */
    private List<PaymentMethodEntity> data = new ArrayList<PaymentMethodEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PaymentMethodEntity entity = new PaymentMethodEntity();
            entity.setMethodName(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createPaymentMethodTest() {
        PaymentMethodDTO dto = new PaymentMethodDTO();
        dto.setMethodName(generateRandom(String.class));

        PaymentMethodDTO result = paymentMethodLogic.createPaymentMethod(dto);

        Assert.assertNotNull(result);

        PaymentMethodEntity entity = em.find(PaymentMethodEntity.class, result.getId());

        Assert.assertEquals(dto.getMethodName(), entity.getMethodName());
    }

    /**
     * @generated
     */
    @Test
    public void getPaymentMethodTest() {
        List<PaymentMethodDTO> list = paymentMethodLogic.getPaymentMethods(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (PaymentMethodDTO dto : list) {
            boolean found = false;
            for (PaymentMethodEntity entity : data) {
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
    public void getPaymentMethodsTest() {
        PaymentMethodEntity entity = data.get(0);
        PaymentMethodDTO dto = paymentMethodLogic.getPaymentMethod(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getMethodName(), dto.getMethodName());
    }

    /**
     * @generated
     */
    @Test
    public void getPaymentMethodPaginationTest() {
        //Page 1
        List<PaymentMethodDTO> dto1 = paymentMethodLogic.getPaymentMethods(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<PaymentMethodDTO> dto2 = paymentMethodLogic.getPaymentMethods(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (PaymentMethodDTO dto : dto1) {
            boolean found = false;
            for (PaymentMethodEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (PaymentMethodDTO dto : dto2) {
            boolean found = false;
            for (PaymentMethodEntity entity : data) {
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
    public void countPaymentMethodTest(){
        Assert.assertEquals(data.size(), paymentMethodLogic.countPaymentMethod()); 
    }
    
    /**
     * Update PaymentMethod product test
     */
    @Test
    public void updateRateTest() {
        
        PaymentMethodEntity entity = data.get(0);
        
        PaymentMethodDTO dto = PaymentMethodConverter.refEntity2DTO(entity);
        Assert.assertNotNull(dto);
        dto.setMethodName("Tarjeta XX");
        dto = paymentMethodLogic.updatePaymentMethod(dto);

        PaymentMethodEntity resp = em.find(PaymentMethodEntity.class, entity.getId());
        Assert.assertNotNull(resp);
        Assert.assertEquals(dto.getMethodName(), resp.getMethodName());
    }
    
    
    
    /**
     * @generated
     */
    @Test
    public void deleteCellPhoneTest() {
        PaymentMethodEntity entity = data.get(0);
        paymentMethodLogic.deletePaymentMethod(entity.getId());
        PaymentMethodEntity deleted = em.find(PaymentMethodEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
}
