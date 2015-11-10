/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.entities.ClientEntity;
import co.edu.uniandes.csw.mpcellphone.entities.ProviderEntity;
import co.edu.uniandes.csw.mpcellphone.entities.RateProviderEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.RateProviderPersistence;
import static co.edu.uniandes.csw.mpcellphone.tests._TestUtil.generateRandom;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author ca.forero10
 */
@RunWith(Arquillian.class)
public class RateProviderPersistenceTest {
    
    public static final String DEPLOY = "Prueba";
    
    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(RateProviderEntity.class.getPackage())
                .addPackage(ProviderEntity.class.getPackage())
                .addPackage(ClientEntity.class.getPackage())
                .addPackage(RateProviderPersistence.class.getPackage())                
                .addPackage(ProviderEntity.class.getPackage())
                .addPackage(ClientEntity.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private RateProviderPersistence rateProviderPersistence;

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
        em.createQuery("delete from RateProviderEntity").executeUpdate();
        em.createQuery("delete from ProviderEntity").executeUpdate();
        em.createQuery("delete from ClientEntity").executeUpdate();
    }

    private List<RateProviderEntity> data = new ArrayList<RateProviderEntity>();
    
    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {            
            RateProviderEntity entity = new RateProviderEntity();
            ProviderEntity product = new ProviderEntity();
            product.setName(generateRandom(String.class));
            em.persist(product);
            ClientEntity client = new ClientEntity();
            client.setName(generateRandom(String.class));
            em.persist(client);
            entity.setClient(client);
            entity.setProvider(product);
            entity.setRate((int)(Math.random()*5)+1);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Create rate product test
     */
    @Test
    public void createRateTest() {
        ProviderEntity pEntity = new ProviderEntity();
        pEntity.setId(data.get(0).getProvider().getId()); 
        ClientEntity cEntity = new ClientEntity();
        cEntity.setId(data.get(0).getClient().getId()); 
        RateProviderEntity rEntity = new RateProviderEntity();
        rEntity.setRate((int)(Math.random()*5)+1);
        rEntity.setClient(cEntity);
        rEntity.setProvider(pEntity);
       
        RateProviderEntity result = rateProviderPersistence.create(rEntity);
        Assert.assertNotNull(result);
        RateProviderEntity entity = em.find(RateProviderEntity.class, result.getId());

        Assert.assertEquals(result.getRate(), entity.getRate());
        Assert.assertEquals(result.getProvider().getId(), entity.getProvider().getId());        
        Assert.assertEquals(result.getClient().getId(), entity.getClient().getId());  
    }

    /**
     * Update rate product test
     */
    @Test
    public void updateRateTest() {
        
        RateProviderEntity entity = data.get(0);
        entity.setRate(0);
        entity = rateProviderPersistence.update(entity);

        RateProviderEntity resp = em.find(RateProviderEntity.class, entity.getId());
        Assert.assertNotNull(resp);
        Assert.assertEquals(entity.getRate(), resp.getRate());
    }

    /**
     * Get rate by product and client test
     */
    @Test
    public void getRateByProviderClientTest() {
        RateProviderEntity entity = data.get(0);
        RateProviderEntity dto = rateProviderPersistence.findByProviderClient(entity.getProvider().getId(),entity.getClient().getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getRate(), dto.getRate());
    }
}
