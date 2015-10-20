package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.ITaxLogic;
import co.edu.uniandes.csw.mpcellphone.converters.TaxConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.TaxDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.TaxLogic;
import co.edu.uniandes.csw.mpcellphone.entities.TaxEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.TaxPersistence;
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
 * @generated
 */
@RunWith(Arquillian.class)
public class TaxLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(TaxEntity.class.getPackage())
                .addPackage(TaxDTO.class.getPackage())
                .addPackage(TaxConverter.class.getPackage())
                .addPackage(TaxLogic.class.getPackage())
                .addPackage(ITaxLogic.class.getPackage())
                .addPackage(TaxPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ITaxLogic stateLogic;

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
        em.createQuery("delete from TaxEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<TaxEntity> data = new ArrayList<TaxEntity>();

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
        TaxDTO dto = new TaxDTO();
        dto.setTaxName(generateRandom(String.class));
        dto.setPercentage(generateRandom(Long.class));

        TaxDTO result = stateLogic.createTax(dto);

        Assert.assertNotNull(result);

        TaxEntity entity = em.find(TaxEntity.class, result.getId());

        Assert.assertEquals(dto.getTaxName(), entity.getTaxName());
        Assert.assertEquals(dto.getPercentage(), entity.getPercentage());
    }

    /**
     * @generated
     */
    @Test
    public void getTaxsTest() {
        List<TaxDTO> list = stateLogic.getTaxs(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (TaxDTO dto : list) {
            boolean found = false;
            for (TaxEntity entity : data) {
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
    public void getTaxTest() {
        TaxEntity entity = data.get(0);
        TaxDTO dto = stateLogic.getTax(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getTaxName(), dto.getTaxName());
        Assert.assertEquals(entity.getPercentage(), dto.getPercentage());
    }

    /**
     * @generated
     */
    @Test
    public void getTaxPaginationTest() {
        //Page 1
        List<TaxDTO> dto1 = stateLogic.getTaxs(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<TaxDTO> dto2 = stateLogic.getTaxs(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (TaxDTO dto : dto1) {
            boolean found = false;
            for (TaxEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (TaxDTO dto : dto2) {
            boolean found = false;
            for (TaxEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
}
