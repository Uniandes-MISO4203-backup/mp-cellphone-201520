/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.entities.CommentEntity;
import static co.edu.uniandes.csw.mpcellphone.tests._TestUtil.*;
import co.edu.uniandes.csw.mpcellphone.persistence.CommentPersistence;
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
 *
 * @author Mauro
 */
@RunWith(Arquillian.class) 
public class CommentPersistenceTest {
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
    private CommentPersistence commentPersistence;
    
    private List<CommentEntity> data = new ArrayList(); 
    
    /**
     * @return 
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(CommentEntity.class.getPackage())
                .addPackage(CommentPersistence.class.getPackage())
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
        em.createQuery("delete from CommentEntity").executeUpdate(); 
    } 
    
     /**
     * @generated
     */
    private void insertData() { 
        for (int i = 0; i < 3; i++) { 
            CommentEntity entity = new CommentEntity();
            entity.setComment(generateRandom(String.class));
            entity.setDate(generateRandom(Date.class));
            entity.setClientId(generateRandom(Long.class));
            entity.setProductId(generateRandom(Long.class));
            
            em.persist(entity); 
            data.add(entity); 
        } 
    }
    
    /**
     * @generated
     */
    @Test
    public void createStateTest() {
        CommentEntity newEntity = new CommentEntity();
        newEntity.setComment(generateRandom(String.class)); 
        newEntity.setDate(generateRandom(Date.class));
        newEntity.setClientId(generateRandom(Long.class));
        newEntity.setProductId(generateRandom(Long.class));

        CommentEntity result = commentPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CommentEntity entity = em.find(CommentEntity.class, result.getId());

        Assert.assertEquals(newEntity.getComment(), entity.getComment());
        Assert.assertEquals(newEntity.getDate(), entity.getDate());
        Assert.assertEquals(newEntity.getClientId(), entity.getClientId());
        Assert.assertEquals(newEntity.getProductId(), entity.getProductId());  
    }

    /**
     * @generated
     */
    @Test
    public void getStateTest() {
        CommentEntity entity = data.get(0);
        CommentEntity newEntity = commentPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getComment(), newEntity.getComment());
    }

    /**
     * @generated
     */
    @Test
    public void deleteStateTest() {
        CommentEntity entity = data.get(0);
        commentPersistence.delete(entity.getId());
        CommentEntity deleted = em.find(CommentEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateStateTest() {
        CommentEntity entity = data.get(0);
        
        CommentEntity newEntity = new CommentEntity();
        newEntity.setComment(generateRandom(String.class));
        entity.setDate(generateRandom(Date.class));
        entity.setClientId(generateRandom(Long.class));
        entity.setProductId(generateRandom(Long.class));

        newEntity.setId(entity.getId());

        commentPersistence.update(newEntity);

        CommentEntity resp = em.find(CommentEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getComment(), resp.getComment());
        Assert.assertEquals(newEntity.getDate(), resp.getDate());
        Assert.assertEquals(newEntity.getClientId(), resp.getClientId());
        Assert.assertEquals(newEntity.getProductId(), resp.getProductId());  
    }
    
        /**
     * @generated
     */
    @Test
    public void getCommentsTest() {
        List<CommentEntity> list = commentPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (CommentEntity ent : list) {
            boolean found = false;
            for (CommentEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    
}
