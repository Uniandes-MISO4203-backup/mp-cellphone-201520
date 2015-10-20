/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.entities.ShippingTypeEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.ShippingTypePersistence;
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
 *
 * @author Mauro
 */
@RunWith(Arquillian.class) 
public class ShippingTypePersistenceTest {
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
    private ShippingTypePersistence shippingTypePersistence;
    
    private List<ShippingTypeEntity> data = new ArrayList(); 
    
    /**
     * @return 
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ShippingTypeEntity.class.getPackage())
                .addPackage(ShippingTypePersistence.class.getPackage())
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
        em.createQuery("delete from ShippingTypeEntity").executeUpdate(); 
    } 
    
     /**
     * @generated
     */
    private void insertData() { 
        for (int i = 0; i < 3; i++) { 
            ShippingTypeEntity entity = new ShippingTypeEntity();
            entity.setName(generateRandom(String.class));
            entity.setValueType(generateRandom(Long.class));
            em.persist(entity); 
            data.add(entity); 
        } 
    }
    
    /**
     * @generated
     */
    @Test
    public void createShippingTypeTest() {        
        ShippingTypeEntity newEntity = new ShippingTypeEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setValueType(generateRandom(Long.class));

        ShippingTypeEntity result = shippingTypePersistence.create(newEntity);

        Assert.assertNotNull(result);

        ShippingTypeEntity entity = em.find(ShippingTypeEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getValueType(), entity.getValueType());
    }

    /**
     * @generated
     */
    @Test
    public void getShippingTypeTest() {
        ShippingTypeEntity entity = data.get(0);
        ShippingTypeEntity newEntity = shippingTypePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getValueType(), newEntity.getValueType());
    }

    /**
     * @generated
     */
    @Test
    public void deleteShippingTypeTest() {
        ShippingTypeEntity entity = data.get(0);
        shippingTypePersistence.delete(entity.getId());
        ShippingTypeEntity deleted = em.find(ShippingTypeEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateShippingTypeTest() {
        ShippingTypeEntity entity = data.get(0);

        ShippingTypeEntity newEntity = new ShippingTypeEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setValueType(generateRandom(Long.class));
        newEntity.setId(entity.getId());

        shippingTypePersistence.update(newEntity);

        ShippingTypeEntity resp = em.find(ShippingTypeEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getValueType(), resp.getValueType());
    }
    
        /**
     * @generated
     */
    @Test
    public void getShippingTypesTest() {
        List<ShippingTypeEntity> list = shippingTypePersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ShippingTypeEntity ent : list) {
            boolean found = false;
            for (ShippingTypeEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    
}
