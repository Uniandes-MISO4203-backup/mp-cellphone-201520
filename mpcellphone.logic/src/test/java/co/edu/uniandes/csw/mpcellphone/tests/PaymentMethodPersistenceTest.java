/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.converters.PaymentMethodConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.PaymentMethodDTO;
import co.edu.uniandes.csw.mpcellphone.entities.PaymentMethodEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.PaymentMethodPersistence;
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
 *
 * @author Mauro
 */
@RunWith(Arquillian.class) 
public class PaymentMethodPersistenceTest {
    /**
     * @generated
     */
    public static final String DEPLOY = "Prueba";
    
    /**
     * @generated
     */
    @Inject 
    UserTransaction utx; 
    
    
    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * @generated
     */
    @Inject
    private PaymentMethodPersistence paymentMethodPersistence;
    
    private List<PaymentMethodEntity> data = new ArrayList(); 
    
    /**
     * @return 
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PaymentMethodEntity.class.getPackage())
                .addPackage(PaymentMethodPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
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
    private void insertData() { 
        for (int i = 0; i < 3; i++) { 
            PodamFactory factory = new PodamFactoryImpl(); 
            PaymentMethodEntity entity = PaymentMethodConverter.basicDTO2Entity(factory.manufacturePojo(PaymentMethodDTO.class)); 
            em.persist(entity); 
            data.add(entity); 
        } 
    }
    
    /**
     * @generated
     */
    @Test
    public void createShippingTypeTest() {
        PodamFactory factory = new PodamFactoryImpl();
        PaymentMethodEntity newEntity = PaymentMethodConverter.basicDTO2Entity(factory.manufacturePojo(PaymentMethodDTO.class));

        PaymentMethodEntity result = paymentMethodPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PaymentMethodEntity entity = em.find(PaymentMethodEntity.class, result.getId());

        Assert.assertEquals(newEntity.getMethodName(), entity.getMethodName());
    }

    /**
     * @generated
     */
    @Test
    public void getShippingTypeTest() {
        PaymentMethodEntity entity = data.get(0);
        PaymentMethodEntity newEntity = paymentMethodPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getMethodName(), newEntity.getMethodName());
    }

    /**
     * @generated
     */
    @Test
    public void deleteShippingTypeTest() {
        PaymentMethodEntity entity = data.get(0);
        paymentMethodPersistence.delete(entity.getId());
        PaymentMethodEntity deleted = em.find(PaymentMethodEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateShippingTypeTest() {
        PaymentMethodEntity entity = data.get(0);

        PodamFactory factory = new PodamFactoryImpl();
        PaymentMethodEntity newEntity = PaymentMethodConverter.basicDTO2Entity(factory.manufacturePojo(PaymentMethodDTO.class));
        newEntity.setId(entity.getId());

        paymentMethodPersistence.update(newEntity);

        PaymentMethodEntity resp = em.find(PaymentMethodEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getMethodName(), resp.getMethodName());
    }
    
        /**
     * @generated
     */
    @Test
    public void getShippingTypesTest() {
        List<PaymentMethodEntity> list = paymentMethodPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (PaymentMethodEntity ent : list) {
            boolean found = false;
            for (PaymentMethodEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    
}
