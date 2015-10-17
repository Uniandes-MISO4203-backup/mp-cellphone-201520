/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.converters.StateConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.StateDTO;
import co.edu.uniandes.csw.mpcellphone.entities.StateEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.StatePersistence;
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
public class StatePersistenceTest {
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
    private StatePersistence statePersistence;
    
    private List<StateEntity> data = new ArrayList(); 
    
    /**
     * @return 
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(StateEntity.class.getPackage())
                .addPackage(StatePersistence.class.getPackage())
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
        em.createQuery("delete from StateEntity").executeUpdate(); 
    } 
    
     /**
     * @generated
     */
    private void insertData() { 
        for (int i = 0; i < 3; i++) { 
            PodamFactory factory = new PodamFactoryImpl(); 
            StateEntity entity = StateConverter.basicDTO2Entity(factory.manufacturePojo(StateDTO.class)); 
            em.persist(entity); 
            data.add(entity); 
        } 
    }
    
    /**
     * @generated
     */
    @Test
    public void createStateTest() {
        PodamFactory factory = new PodamFactoryImpl();
        StateEntity newEntity = StateConverter.basicDTO2Entity(factory.manufacturePojo(StateDTO.class));

        StateEntity result = statePersistence.create(newEntity);

        Assert.assertNotNull(result);

        StateEntity entity = em.find(StateEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getStateTest() {
        StateEntity entity = data.get(0);
        StateEntity newEntity = statePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void deleteStateTest() {
        StateEntity entity = data.get(0);
        statePersistence.delete(entity.getId());
        StateEntity deleted = em.find(StateEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateStateTest() {
        StateEntity entity = data.get(0);

        PodamFactory factory = new PodamFactoryImpl();
        StateEntity newEntity = StateConverter.basicDTO2Entity(factory.manufacturePojo(StateDTO.class));
        newEntity.setId(entity.getId());

        statePersistence.update(newEntity);

        StateEntity resp = em.find(StateEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
    
    
}
