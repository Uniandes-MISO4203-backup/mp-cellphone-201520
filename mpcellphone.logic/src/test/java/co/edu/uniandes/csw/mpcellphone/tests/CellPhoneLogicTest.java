package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.ejbs.CellPhoneLogic;
import co.edu.uniandes.csw.mpcellphone.api.ICellPhoneLogic;
import co.edu.uniandes.csw.mpcellphone.converters.CellPhoneConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.CellPhoneDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CellPhoneEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.CellPhonePersistence;
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
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CellPhoneLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(CellPhoneEntity.class.getPackage())
                .addPackage(CellPhoneDTO.class.getPackage())
                .addPackage(CellPhoneConverter.class.getPackage())
                .addPackage(CellPhoneLogic.class.getPackage())
                .addPackage(ICellPhoneLogic.class.getPackage())
                .addPackage(CellPhonePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ICellPhoneLogic cellPhoneLogic;

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
        em.createQuery("delete from CellPhoneEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<CellPhoneEntity> data = new ArrayList<CellPhoneEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            CellPhoneEntity entity = factory.manufacturePojo(CellPhoneEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Test countCellphone method
     */ 
    @Test
    public void countCellPhonesTest(){
        Assert.assertEquals(data.size(), cellPhoneLogic.countCellPhones()); 
    }

    /**
     * @generated
     */
    @Test
    public void createCellPhoneTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CellPhoneDTO dto = factory.manufacturePojo(CellPhoneDTO.class);
        CellPhoneDTO result = cellPhoneLogic.createCellPhone(dto);

        Assert.assertNotNull(result);

        CellPhoneEntity entity = em.find(CellPhoneEntity.class, result.getId());
        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getBrand(), entity.getBrand());
    }

    /**
     * @generated
     */
    @Test
    public void getCellPhonesTest() {
        List<CellPhoneDTO> list = cellPhoneLogic.getCellPhones(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (CellPhoneDTO dto : list) {
            boolean found = false;
            for (CellPhoneEntity entity : data) {
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
    public void getCellPhoneTest() {
        CellPhoneEntity entity = data.get(0);
        CellPhoneDTO dto = cellPhoneLogic.getCellPhone(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getBrand(), dto.getBrand());
    }

    /**
     * @generated
     */
    @Test
    public void deleteCellPhoneTest() {
        CellPhoneEntity entity = data.get(0);
        cellPhoneLogic.deleteCellPhone(entity.getId());
        CellPhoneEntity deleted = em.find(CellPhoneEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateCellPhoneTest() {
        CellPhoneEntity entity = data.get(0);

        CellPhoneDTO dto = new CellPhoneDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setBrand(generateRandom(String.class));

        cellPhoneLogic.updateCellPhone(dto);

        CellPhoneEntity resp = em.find(CellPhoneEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getBrand(), resp.getBrand());
    }

    /**
     * @generated
     */
    @Test
    public void getCellPhonePaginationTest() {
        //Page 1
        List<CellPhoneDTO> dto1 = cellPhoneLogic.getCellPhones(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<CellPhoneDTO> dto2 = cellPhoneLogic.getCellPhones(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (CellPhoneDTO dto : dto1) {
            boolean found = false;
            for (CellPhoneEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (CellPhoneDTO dto : dto2) {
            boolean found = false;
            for (CellPhoneEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }  
    /**
     * Method to test findByName
     */
    @Test
    public void findByNameTest(){
        for(CellPhoneEntity entity: data){
            int nameQuantity = 0;
            for(CellPhoneEntity entityTest: data){
                if(entityTest.getName().equals(entity.getName())){
                    nameQuantity++;
                }
            }
            List<CellPhoneDTO> cellPhones = cellPhoneLogic.findByName(entity.getName());
            Assert.assertNotNull(cellPhones);
            Assert.assertEquals(nameQuantity, cellPhones.size());
            for(CellPhoneDTO dto: cellPhones){
                Assert.assertNotNull(dto);
                Assert.assertEquals(entity.getName(), dto.getName());
            }
        }
    }
    
    /**
     * Method to test cellPhoneModelTest
     */
    @Test
    public void getCellPhoneModelTest(){        
        List<CellPhoneDTO> cellPhones = cellPhoneLogic.getCellPhoneModel();
        Assert.assertNotNull(cellPhones);
        for(CellPhoneDTO dto: cellPhones){
            Assert.assertNotNull(dto);
            Assert.assertNotNull(dto.getName());
        }
        List<String> list = em.createNamedQuery("CellPhone.getCellPhoneModel").getResultList();
        Assert.assertEquals(cellPhones.size(), list.size());
        ArrayList<String> names = new ArrayList<String>();
        for(CellPhoneDTO dto: cellPhones){
            names.add(dto.getName());
        }
        Assert.assertArrayEquals(list.toArray(), names.toArray());
    }
    
    /**
     * Method to test cellPhoneBrandTest
     */
    @Test
    public void getCellPhoneBrandTest(){        
        List<CellPhoneDTO> cellPhones = cellPhoneLogic.getCellPhoneBrand();
        Assert.assertNotNull(cellPhones);
        for(CellPhoneDTO dto: cellPhones){
            Assert.assertNotNull(dto);
            Assert.assertNotNull(dto.getName());
        }
        List<String> list = em.createNamedQuery("CellPhone.getCellPhoneBrand").getResultList();
        Assert.assertEquals(cellPhones.size(), list.size());
        ArrayList<String> names = new ArrayList<String>();
        for(CellPhoneDTO dto: cellPhones){
            names.add(dto.getName());
        }
        Assert.assertArrayEquals(list.toArray(), names.toArray());
    }
}
