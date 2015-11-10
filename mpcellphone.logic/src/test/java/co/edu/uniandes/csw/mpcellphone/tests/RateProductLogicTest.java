package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.IRateProductLogic;
import co.edu.uniandes.csw.mpcellphone.converters.RateProductConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProductDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.RateProductDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.RateProductLogic;
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
public class RateProductLogicTest {
    
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
                .addPackage(RateProductDTO.class.getPackage())
                .addPackage(ProductDTO.class.getPackage())
                .addPackage(ClientDTO.class.getPackage())
                .addPackage(RateProductConverter.class.getPackage())
                .addPackage(RateProductLogic.class.getPackage())
                .addPackage(IRateProductLogic.class.getPackage())
                .addPackage(RateProductPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private IRateProductLogic rateProductLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    /**
     * Configuration test
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
     * Clear Data
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
        ProductDTO dto = new ProductDTO();
        dto.setName(generateRandom(String.class));
        dto.setId(data.get(0).getProduct().getId()); 
        ClientDTO dtoC = new ClientDTO();
        dtoC.setName(generateRandom(String.class));
        dtoC.setId(data.get(0).getClient().getId()); 
        RateProductDTO dtoR = new RateProductDTO();
        dtoR.setRate((int)(Math.random()*5)+1);
        dtoR.setClient(dtoC);
        dtoR.setProduct(dto);
       
        RateProductDTO result = rateProductLogic.createRate(dtoR);
        Assert.assertNotNull(result);
        RateProductEntity entity = em.find(RateProductEntity.class, result.getId());

        Assert.assertEquals(dtoR.getRate(), entity.getRate());
        Assert.assertEquals(dtoR.getProduct().getId(), entity.getProduct().getId());        
        Assert.assertEquals(dtoR.getClient().getId(), entity.getClient().getId());  
    }

    /**
     * Update rate product test
     */
    @Test
    public void updateRateTest() {
        
        RateProductEntity entity = data.get(0);
        
        RateProductDTO dto = RateProductConverter.refEntity2DTO(entity);
        Assert.assertNotNull(dto);
        dto.setRate(0);
        dto = rateProductLogic.updateRate(dto);

        RateProductEntity resp = em.find(RateProductEntity.class, entity.getId());
        Assert.assertNotNull(resp);
        Assert.assertEquals(dto.getRate(), resp.getRate());
    }

    /**
     * Get rate by product and client test
     */
    @Test
    public void getRateByProductClientTest() {
        RateProductEntity entity = data.get(0);
        RateProductDTO dto = rateProductLogic.getRateByProductClient(entity.getProduct().getId(),entity.getClient().getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getRate(), dto.getRate());
        
        RateProductDTO dtoNew = RateProductConverter.fullEntity2DTO(entity);
        Assert.assertNotNull(dtoNew);
        Assert.assertEquals(dtoNew.getRate(), dto.getRate());
        Assert.assertEquals(dtoNew.getId(), dto.getId());
        Assert.assertEquals(dtoNew.getProduct().getId(), dto.getProduct().getId());
        Assert.assertEquals(dtoNew.getClient().getId(), dto.getClient().getId());
    }
    
}
