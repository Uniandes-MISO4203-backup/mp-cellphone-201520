package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.ejbs.ProductLogic;
import co.edu.uniandes.csw.mpcellphone.api.IProductLogic;
import co.edu.uniandes.csw.mpcellphone.converters.ProductConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.CellPhoneDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.CityDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProductDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProviderDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CellPhoneEntity;
import co.edu.uniandes.csw.mpcellphone.entities.CityEntity;
import co.edu.uniandes.csw.mpcellphone.entities.PhotoEntity;
import co.edu.uniandes.csw.mpcellphone.entities.ProductEntity;
import co.edu.uniandes.csw.mpcellphone.entities.ProviderEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.ProductPersistence;
import static co.edu.uniandes.csw.mpcellphone.tests._TestUtil.*;
import java.util.ArrayList;
import java.util.Collections;
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
public class ProductLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ProductEntity.class.getPackage())
                .addPackage(ProviderEntity.class.getPackage())
                .addPackage(CellPhoneEntity.class.getPackage())
                .addPackage(CityEntity.class.getPackage())
                .addPackage(PhotoEntity.class.getPackage())
                .addPackage(ProductDTO.class.getPackage())
                .addPackage(ProviderDTO.class.getPackage())
                .addPackage(CellPhoneDTO.class.getPackage())
                .addPackage(CityDTO.class.getPackage())
                .addPackage(ProductConverter.class.getPackage())
                .addPackage(ProductLogic.class.getPackage())
                .addPackage(IProductLogic.class.getPackage())
                .addPackage(ProductPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IProductLogic productLogic;

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
        em.createQuery("delete from PhotoEntity").executeUpdate();
        em.createQuery("delete from ProductEntity").executeUpdate();
        em.createQuery("delete from ProviderEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ProductEntity> data = new ArrayList<ProductEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ProviderEntity provider = new ProviderEntity();             
            provider.setProducts(Collections.EMPTY_LIST);
            em.persist(provider);
            CellPhoneEntity cellPhone = new CellPhoneEntity();
            cellPhone.setName(generateRandom(String.class));
            cellPhone.setBrand(generateRandom(String.class));
            em.persist(cellPhone);
            CityEntity city = new CityEntity();
            city.setName(generateRandom(String.class));
            em.persist(city);
            PhotoEntity photo1 = new PhotoEntity();
            photo1.setImage(generateRandom(String.class));
            photo1.setName(generateRandom(String.class));
            PhotoEntity photo2 = new PhotoEntity();
            photo2.setImage(generateRandom(String.class));
            photo2.setName(generateRandom(String.class));
            em.persist(photo1);
            em.persist(photo2);
            ProductEntity entity = new ProductEntity();
            entity.setName(generateRandom(String.class));
            entity.setPrice(generateRandom(Long.class));
            entity.setCategory(generateRandom(String.class));
            entity.setDiscount(generateRandom(Integer.class));
            entity.setDescription(generateRandom(String.class));
            entity.setImage(generateRandom(String.class));
            entity.setImei(generateRandom(String.class));
            ArrayList<PhotoEntity> photos = new ArrayList<PhotoEntity>();
            photos.add(photo2);photos.add(photo1);
            entity.setPhotos(photos);
            entity.setProvider(provider);
            entity.setCellPhone(cellPhone);
            entity.setCity(city);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createProductTest() {
        ProductDTO dto = new ProductDTO();
        dto.setName(generateRandom(String.class));
        dto.setPrice(generateRandom(Long.class));
        dto.setCategory(generateRandom(String.class));
        dto.setDiscount(generateRandom(Integer.class));
        dto.setDescription(generateRandom(String.class));
        dto.setImage(generateRandom(String.class));
        dto.setImei(generateRandom(String.class));
        ProviderDTO dtoP =new ProviderDTO();
        dtoP.setId(data.get(0).getProvider().getId()); 
        dto.setProvider(dtoP);
        CityDTO city = new CityDTO();
        city.setId(data.get(0).getCity().getId());
        dto.setCity(city);
        CellPhoneDTO cellPhone = new CellPhoneDTO();
        cellPhone.setId(data.get(0).getCellPhone().getId());
        dto.setCellPhone(cellPhone);
        ProductDTO result = productLogic.createProduct(dto);
        Assert.assertNotNull(result);
        ProductEntity entity = em.find(ProductEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getPrice(), entity.getPrice());        
        Assert.assertEquals(dto.getCategory(), entity.getCategory());
        Assert.assertEquals(dto.getDiscount(), entity.getDiscount());
        Assert.assertEquals(dto.getDescription(), entity.getDescription());
        Assert.assertEquals(dto.getImage(), entity.getImage());
        Assert.assertEquals(dto.getImei(), entity.getImei());
    }

    /**
     * @generated
     */
    @Test
    public void getProductsTest() {
        List<ProductDTO> list = productLogic.getProducts(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ProductDTO dto : list) {
            boolean found = false;
            for (ProductEntity entity : data) {
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
    public void getProductTest() {
        ProductEntity entity = data.get(0);
        ProductDTO dto = productLogic.getProduct(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getPrice(), dto.getPrice());
        Assert.assertEquals(entity.getCategory(), dto.getCategory());
        Assert.assertEquals(entity.getDiscount(), dto.getDiscount());
        Assert.assertEquals(entity.getDescription(), dto.getDescription());
        Assert.assertEquals(entity.getImage(), dto.getImage());
        Assert.assertEquals(entity.getImei(), dto.getImei());
    }

    /**
     * @generated
     */
    @Test
    public void deleteProductTest() {
        ProductEntity entity = data.get(0);
        productLogic.deleteProduct(entity.getId());
        ProductEntity deleted = em.find(ProductEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateProductTest() {
        ProductEntity entity = data.get(0);
        
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setPrice(generateRandom(Long.class));
        dto.setCategory(generateRandom(String.class));
        dto.setDiscount(generateRandom(Integer.class));
        dto.setDescription(generateRandom(String.class));
        dto.setImage(generateRandom(String.class));
        dto.setImei(generateRandom(String.class));
        dto = productLogic.updateProduct(dto);

        ProductEntity resp = em.find(ProductEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getPrice(), resp.getPrice());
        Assert.assertEquals(dto.getCategory(), resp.getCategory());
        Assert.assertEquals(dto.getDiscount(), resp.getDiscount());
        Assert.assertEquals(dto.getDescription(), resp.getDescription());
        Assert.assertEquals(dto.getImage(), resp.getImage());
        Assert.assertEquals(dto.getImei(), resp.getImei());
    }

    /**
     * @generated
     */
    @Test
    public void getProductPaginationTest() {
        //Page 1
        List<ProductDTO> dto1 = productLogic.getProducts(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<ProductDTO> dto2 = productLogic.getProducts(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (ProductDTO dto : dto1) {
            boolean found = false;
            for (ProductEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ProductDTO dto : dto2) {
            boolean found = false;
            for (ProductEntity entity : data) {
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
        List<ProductEntity> cache = new ArrayList<ProductEntity>();
        List<ProductDTO> list = productLogic.findByName(name);

        for (ProductEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ProductDTO dto : list) {
            boolean found = false;
            for (ProductEntity cacheEntity : cache) {
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
    
    /**
     * Test countProduct method
     */ 
    @Test
    public void countProductsTest(){
        Assert.assertEquals(data.size(), productLogic.countProducts()); 
    }
    
    /**
     * Test getByCellPhoneName method
     */ 
    @Test
    public void getByCellPhoneNameTest(){
        String name = data.get(0).getName();
        List<ProductEntity> cache = new ArrayList<ProductEntity>();
        List<ProductDTO> list = productLogic.getByCellPhoneName(name);

        for (ProductEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ProductDTO dto : list) {
            boolean found = false;
            for (ProductEntity cacheEntity : cache) {
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
    
    /**
     * Test getCheaperProduct method
     */ 
    @Test
    public void getCheaperProductTest(){
        Long id = data.get(0).getProvider().getId();
        ProductDTO dto = productLogic.getCheaperProduct(id);
        Assert.assertNotNull(dto);
        Long price = Long.MAX_VALUE;
        ProductEntity cheapest = null;
        for(ProductEntity entity: data){
            if(entity.getProvider().getId()==id&&entity.getPrice()<price){
                price=entity.getPrice();
                cheapest=entity;
            }
        }        
        Assert.assertEquals(cheapest.getId(), dto.getId());
        Assert.assertEquals(cheapest.getPrice(), dto.getPrice());
        Assert.assertEquals(cheapest.getProvider().getId(), dto.getProvider().getId());
    }
}
