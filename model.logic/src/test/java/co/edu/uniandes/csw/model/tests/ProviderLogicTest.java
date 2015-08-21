package co.edu.uniandes.csw.model.tests;

import co.edu.uniandes.csw.model.ejbs.ProviderLogic;
import co.edu.uniandes.csw.model.api.IProviderLogic;
import co.edu.uniandes.csw.model.converters.ProviderConverter;
import co.edu.uniandes.csw.model.dtos.ProviderDTO;
import co.edu.uniandes.csw.model.entities.ProviderEntity;
import co.edu.uniandes.csw.model.persistence.ProviderPersistence;
import static co.edu.uniandes.csw.model.tests._TestUtil.*;
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
public class ProviderLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ProviderEntity.class.getPackage())
                .addPackage(ProviderDTO.class.getPackage())
                .addPackage(ProviderConverter.class.getPackage())
                .addPackage(ProviderLogic.class.getPackage())
                .addPackage(IProviderLogic.class.getPackage())
                .addPackage(ProviderPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IProviderLogic providerLogic;

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
        em.createQuery("delete from ProviderEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ProviderEntity> data = new ArrayList<ProviderEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ProviderEntity entity = new ProviderEntity();
        	entity.setName(generateRandom(String.class));
        	entity.setUserId(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createProviderTest() {
        ProviderDTO dto = new ProviderDTO();
        dto.setName(generateRandom(String.class));
        dto.setUserId(generateRandom(String.class));

        ProviderDTO result = providerLogic.createProvider(dto);

        Assert.assertNotNull(result);

        ProviderEntity entity = em.find(ProviderEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getUserId(), entity.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getProvidersTest() {
        List<ProviderDTO> list = providerLogic.getProviders(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ProviderDTO dto : list) {
            boolean found = false;
            for (ProviderEntity entity : data) {
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
    public void getProviderTest() {
        ProviderEntity entity = data.get(0);
        ProviderDTO dto = providerLogic.getProvider(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getUserId(), dto.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void deleteProviderTest() {
        ProviderEntity entity = data.get(0);
        providerLogic.deleteProvider(entity.getId());
        ProviderEntity deleted = em.find(ProviderEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateProviderTest() {
        ProviderEntity entity = data.get(0);

        ProviderDTO dto = new ProviderDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setUserId(generateRandom(String.class));

        providerLogic.updateProvider(dto);

        ProviderEntity resp = em.find(ProviderEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getUserId(), resp.getUserId());
    }

    /**
     * @generated
     */
    @Test
    public void getProviderPaginationTest() {
        //Page 1
        List<ProviderDTO> dto1 = providerLogic.getProviders(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<ProviderDTO> dto2 = providerLogic.getProviders(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (ProviderDTO dto : dto1) {
            boolean found = false;
            for (ProviderEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ProviderDTO dto : dto2) {
            boolean found = false;
            for (ProviderEntity entity : data) {
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
    public void findByName() {
        String name = data.get(0).getName();
        List<ProviderEntity> cache = new ArrayList<ProviderEntity>();
        List<ProviderDTO> list = providerLogic.findByName(name);

        for (ProviderEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ProviderDTO dto : list) {
            boolean found = false;
            for (ProviderEntity cacheEntity : cache) {
                if (cacheEntity.getName().equals(dto.getName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Assert.fail();
            }
        }
    }
}
