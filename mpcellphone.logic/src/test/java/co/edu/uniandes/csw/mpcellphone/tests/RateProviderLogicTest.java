package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.IRateProviderLogic;
import co.edu.uniandes.csw.mpcellphone.converters.RateProviderConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProviderDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.RateProviderDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.RateProviderLogic;
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
public class RateProviderLogicTest {
    
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
                .addPackage(RateProviderDTO.class.getPackage())
                .addPackage(ProviderDTO.class.getPackage())
                .addPackage(ClientDTO.class.getPackage())
                .addPackage(RateProviderConverter.class.getPackage())
                .addPackage(RateProviderLogic.class.getPackage())
                .addPackage(IRateProviderLogic.class.getPackage())
                .addPackage(RateProviderPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private IRateProviderLogic rateProviderLogic;
    
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
            ProviderEntity provider = new ProviderEntity();
            provider.setName(generateRandom(String.class));
            em.persist(provider);
            ClientEntity client = new ClientEntity();
            client.setName(generateRandom(String.class));
            em.persist(client);
            entity.setClient(client);
            entity.setProvider(provider);
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
        ProviderDTO dto = new ProviderDTO();
        dto.setName(generateRandom(String.class));
        dto.setId(data.get(0).getProvider().getId()); 
        ClientDTO dtoC = new ClientDTO();
        dtoC.setName(generateRandom(String.class));
        dtoC.setId(data.get(0).getClient().getId()); 
        RateProviderDTO dtoR = new RateProviderDTO();
        dtoR.setRate((int)(Math.random()*5)+1);
        dtoR.setClient(dtoC);
        dtoR.setProvider(dto);
       
        RateProviderDTO result = rateProviderLogic.createRate(dtoR);
        Assert.assertNotNull(result);
        RateProviderEntity entity = em.find(RateProviderEntity.class, result.getId());

        Assert.assertEquals(dtoR.getRate(), entity.getRate());
        Assert.assertEquals(dtoR.getProvider().getId(), entity.getProvider().getId());        
        Assert.assertEquals(dtoR.getClient().getId(), entity.getClient().getId());  
    }

    /**
     * Update rate product test
     */
    @Test
    public void updateRateTest() {
        
        RateProviderEntity entity = data.get(0);
        
        RateProviderDTO dto = RateProviderConverter.refEntity2DTO(entity);
        Assert.assertNotNull(dto);
        dto.setRate(0);
        dto = rateProviderLogic.updateRate(dto);

        RateProviderEntity resp = em.find(RateProviderEntity.class, entity.getId());
        Assert.assertNotNull(resp);
        Assert.assertEquals(dto.getRate(), resp.getRate());
    }

    /**
     * Get rate by product and client test
     */
    @Test
    public void getRateByProviderClientTest() {
        RateProviderEntity entity = data.get(0);
        RateProviderDTO dto = rateProviderLogic.getRateByProviderClient(entity.getProvider().getId(),entity.getClient().getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getRate(), dto.getRate());
        
        RateProviderDTO dtoNew = RateProviderConverter.fullEntity2DTO(entity);
        Assert.assertNotNull(dtoNew);
        Assert.assertEquals(dtoNew.getRate(), dto.getRate());
        Assert.assertEquals(dtoNew.getId(), dto.getId());
        Assert.assertEquals(dtoNew.getProvider().getId(), dto.getProvider().getId());
        Assert.assertEquals(dtoNew.getClient().getId(), dto.getClient().getId());
    }
    
}

