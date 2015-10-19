package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.IShippingTypeLogic;
import co.edu.uniandes.csw.mpcellphone.converters.ShippingTypeConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.ShippingTypeDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.ShippingTypeLogic;
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
 * @generated
 */
@RunWith(Arquillian.class)
public class ShippingTypeLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ShippingTypeEntity.class.getPackage())
                .addPackage(ShippingTypeDTO.class.getPackage())
                .addPackage(ShippingTypeConverter.class.getPackage())
                .addPackage(ShippingTypeLogic.class.getPackage())
                .addPackage(IShippingTypeLogic.class.getPackage())
                .addPackage(ShippingTypePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IShippingTypeLogic shippingTypeLogic;

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
        em.createQuery("delete from ShippingTypeEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ShippingTypeEntity> data = new ArrayList<ShippingTypeEntity>();

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
        ShippingTypeDTO dto = new ShippingTypeDTO();
        dto.setName(generateRandom(String.class));
        dto.setValueType(generateRandom(Long.class));

        ShippingTypeDTO result = shippingTypeLogic.createShippingType(dto);

        Assert.assertNotNull(result);

        ShippingTypeEntity entity = em.find(ShippingTypeEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getShippingTypeTest() {
        List<ShippingTypeDTO> list = shippingTypeLogic.getShippingTypes(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ShippingTypeDTO dto : list) {
            boolean found = false;
            for (ShippingTypeEntity entity : data) {
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
    public void updatePhotoTest() {
        ShippingTypeEntity entity = data.get(0);

        ShippingTypeDTO dto = new ShippingTypeDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setValueType(generateRandom(Long.class));

        shippingTypeLogic.updateShippingType(dto);

        ShippingTypeEntity resp = em.find(ShippingTypeEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getShippingTypesTest() {
        ShippingTypeEntity entity = data.get(0);
        ShippingTypeDTO dto = shippingTypeLogic.getShippingType(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getShippingTypePaginationTest() {
        //Page 1
        List<ShippingTypeDTO> dto1 = shippingTypeLogic.getShippingTypes(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<ShippingTypeDTO> dto2 = shippingTypeLogic.getShippingTypes(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (ShippingTypeDTO dto : dto1) {
            boolean found = false;
            for (ShippingTypeEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ShippingTypeDTO dto : dto2) {
            boolean found = false;
            for (ShippingTypeEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Test countCellphone method
     */ 
    @Test
    public void countShippingTypeTest(){
        Assert.assertEquals(data.size(), shippingTypeLogic.countShippingType()); 
    }
    
}
