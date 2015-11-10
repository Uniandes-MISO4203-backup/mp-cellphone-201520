package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.entities.ClientEntity;
import co.edu.uniandes.csw.mpcellphone.entities.ProductEntity;
import co.edu.uniandes.csw.mpcellphone.entities.RateProductEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.RateProductPersistence;
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
public class RateProductPersistenceTest {
    
    public static final String DEPLOY = "Prueba";
    
    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(RateProductEntity.class.getPackage())
                .addPackage(ProductEntity.class.getPackage())
                .addPackage(ClientEntity.class.getPackage())
                .addPackage(RateProductPersistence.class.getPackage())                
                .addPackage(ProductEntity.class.getPackage())
                .addPackage(ClientEntity.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private RateProductPersistence rateProductPersistence;

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
        em.createQuery("delete from RateProductEntity").executeUpdate();
        em.createQuery("delete from ProductEntity").executeUpdate();
        em.createQuery("delete from ClientEntity").executeUpdate();
    }

    private List<RateProductEntity> data = new ArrayList<RateProductEntity>();
    
    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {            
            RateProductEntity entity = new RateProductEntity();
            ProductEntity product = new ProductEntity();
            product.setName(generateRandom(String.class));
            em.persist(product);
            ClientEntity client = new ClientEntity();
            client.setName(generateRandom(String.class));
            em.persist(client);
            entity.setClient(client);
            entity.setProduct(product);
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
        ProductEntity pEntity = new ProductEntity();
        pEntity.setId(data.get(0).getProduct().getId()); 
        ClientEntity cEntity = new ClientEntity();
        cEntity.setId(data.get(0).getClient().getId()); 
        RateProductEntity rEntity = new RateProductEntity();
        rEntity.setRate((int)(Math.random()*5)+1);
        rEntity.setClient(cEntity);
        rEntity.setProduct(pEntity);
       
        RateProductEntity result = rateProductPersistence.create(rEntity);
        Assert.assertNotNull(result);
        RateProductEntity entity = em.find(RateProductEntity.class, result.getId());

        Assert.assertEquals(result.getRate(), entity.getRate());
        Assert.assertEquals(result.getProduct().getId(), entity.getProduct().getId());        
        Assert.assertEquals(result.getClient().getId(), entity.getClient().getId());  
    }

    /**
     * Update rate product test
     */
    @Test
    public void updateRateTest() {
        
        RateProductEntity entity = data.get(0);
        entity.setRate(0);
        entity = rateProductPersistence.update(entity);

        RateProductEntity resp = em.find(RateProductEntity.class, entity.getId());
        Assert.assertNotNull(resp);
        Assert.assertEquals(entity.getRate(), resp.getRate());
    }

    /**
     * Get rate by product and client test
     */
    @Test
    public void getRateByProductClientTest() {
        RateProductEntity entity = data.get(0);
        RateProductEntity dto = rateProductPersistence.findByProductClient(entity.getProduct().getId(),entity.getClient().getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getRate(), dto.getRate());
    }
}
