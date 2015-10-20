/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.entities.TaxEntity;
import static co.edu.uniandes.csw.mpcellphone.tests._TestUtil.*;
import co.edu.uniandes.csw.mpcellphone.persistence.TaxPersistence;
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
public class TaxtPersistenceTest {
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
    private TaxPersistence statePersistence;
    
    private List<TaxEntity> data = new ArrayList(); 
    
    /**
     * @return 
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(TaxEntity.class.getPackage())
                .addPackage(TaxPersistence.class.getPackage())
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
        em.createQuery("delete from TaxEntity").executeUpdate(); 
    } 
    
     /**
     * @generated
     */
    private void insertData() { 
        for (int i = 0; i < 3; i++) { 
            TaxEntity entity = new TaxEntity();
            entity.setTaxName(generateRandom(String.class));
            entity.setPercentage(generateRandom(Long.class));
            em.persist(entity); 
            data.add(entity); 
        } 
    }
    
    /**
     * @generated
     */
    @Test
    public void createStateTest() {
        TaxEntity newEntity = new TaxEntity();
        newEntity.setTaxName(generateRandom(String.class));
        newEntity.setPercentage(generateRandom(Long.class));

        TaxEntity result = statePersistence.create(newEntity);

        Assert.assertNotNull(result);

        TaxEntity entity = em.find(TaxEntity.class, result.getId());

        Assert.assertEquals(newEntity.getTaxName(), entity.getTaxName());
        Assert.assertEquals(newEntity.getPercentage(), entity.getPercentage());
    }

    /**
     * @generated
     */
    @Test
    public void getStateTest() {
        TaxEntity entity = data.get(0);
        TaxEntity newEntity = statePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getTaxName(), newEntity.getTaxName());
        Assert.assertEquals(entity.getPercentage(), newEntity.getPercentage());
    }

    /**
     * @generated
     */
    @Test
    public void deleteStateTest() {
        TaxEntity entity = data.get(0);
        statePersistence.delete(entity.getId());
        TaxEntity deleted = em.find(TaxEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateStateTest() {
        TaxEntity entity = data.get(0);
        
        TaxEntity newEntity = new TaxEntity();
        newEntity.setTaxName(generateRandom(String.class));
        newEntity.setPercentage(generateRandom(Long.class));

        newEntity.setId(entity.getId());

        statePersistence.update(newEntity);

        TaxEntity resp = em.find(TaxEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getTaxName(), resp.getTaxName());
        Assert.assertEquals(newEntity.getPercentage(), resp.getPercentage());
    }
    
        /**
     * @generated
     */
    @Test
    public void getStatesTest() {
        List<TaxEntity> list = statePersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (TaxEntity ent : list) {
            boolean found = false;
            for (TaxEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    
}
