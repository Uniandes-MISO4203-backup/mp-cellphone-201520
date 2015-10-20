package co.edu.uniandes.csw.mpcellphone.tests;

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

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ProductPersistenceTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ProductEntity.class.getPackage())
                .addPackage(ProductPersistence.class.getPackage())                
                .addPackage(ProviderEntity.class.getPackage())
                .addPackage(CellPhoneEntity.class.getPackage())
                .addPackage(CityEntity.class.getPackage())
                .addPackage(PhotoEntity.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ProductPersistence productPersistence;

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
        em.createQuery("delete from ProductEntity").executeUpdate();
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
            provider.setName(generateRandom(String.class));
            provider.setCity(generateRandom(String.class));
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
        ProductEntity newEntity = new ProductEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setPrice(generateRandom(Long.class));
        newEntity.setCategory(generateRandom(String.class));
        newEntity.setDiscount(generateRandom(Integer.class));
        newEntity.setDescription(generateRandom(String.class));
        newEntity.setImage(generateRandom(String.class));
        newEntity.setImei(generateRandom(String.class));

        ProviderEntity provider =new ProviderEntity();
        provider.setId(data.get(0).getProvider().getId()); 
        newEntity.setProvider(provider);
        CityEntity city = new CityEntity();
        city.setId(data.get(0).getCity().getId());
        newEntity.setCity(city);
        CellPhoneEntity cellPhone = new CellPhoneEntity();
        cellPhone.setId(data.get(0).getCellPhone().getId());
        newEntity.setCellPhone(cellPhone);
        ProductEntity result = productPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ProductEntity entity = em.find(ProductEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getPrice(), entity.getPrice());      
        Assert.assertEquals(newEntity.getCategory(), entity.getCategory());
        Assert.assertEquals(newEntity.getDiscount(), entity.getDiscount());
        Assert.assertEquals(newEntity.getDescription(), entity.getDescription());
        Assert.assertEquals(newEntity.getImage(), entity.getImage());
        Assert.assertEquals(newEntity.getImei(), entity.getImei());
    }

    /**
     * @generated
     */
    @Test
    public void getProductsTest() {
        List<ProductEntity> list = productPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ProductEntity ent : list) {
            boolean found = false;
            for (ProductEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
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
        ProductEntity newEntity = productPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getPrice(), newEntity.getPrice());
        Assert.assertEquals(entity.getCategory(), newEntity.getCategory());
        Assert.assertEquals(entity.getDiscount(), newEntity.getDiscount());
        Assert.assertEquals(entity.getDescription(), newEntity.getDescription());
        Assert.assertEquals(entity.getImage(), newEntity.getImage());
        Assert.assertEquals(entity.getImei(), newEntity.getImei());
    }

    /**
     * @generated
     */
    @Test
    public void deleteProductTest() {
        ProductEntity entity = data.get(0);
        productPersistence.delete(entity.getId());
        ProductEntity deleted = em.find(ProductEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateProductTest() {
        ProductEntity entity = data.get(0);

        ProductEntity newEntity = new ProductEntity();

        newEntity.setId(entity.getId());
        newEntity.setName(generateRandom(String.class));
        newEntity.setPrice(generateRandom(Long.class));
        newEntity.setCategory(generateRandom(String.class));
        newEntity.setDiscount(generateRandom(Integer.class));
        newEntity.setDescription(generateRandom(String.class));
        newEntity.setImage(generateRandom(String.class));
        newEntity.setImei(generateRandom(String.class));

        productPersistence.update(newEntity);

        ProductEntity resp = em.find(ProductEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getPrice(), resp.getPrice());        
        Assert.assertEquals(newEntity.getCategory(), resp.getCategory());
        Assert.assertEquals(newEntity.getDiscount(), resp.getDiscount());
        Assert.assertEquals(newEntity.getDescription(), resp.getDescription());
        Assert.assertEquals(newEntity.getImage(), resp.getImage());
        Assert.assertEquals(newEntity.getImei(), resp.getImei());
    }

    /**
     * @generated
     */
    @Test
    public void getProductPaginationTest() {
        //Page 1
        List<ProductEntity> ent1 = productPersistence.findAll(1, 2);
        Assert.assertNotNull(ent1);
        Assert.assertEquals(2, ent1.size());
        //Page 2
        List<ProductEntity> ent2 = productPersistence.findAll(2, 2);
        Assert.assertNotNull(ent2);
        Assert.assertEquals(1, ent2.size());

        for (ProductEntity ent : ent1) {
            boolean found = false;
            for (ProductEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ProductEntity ent : ent2) {
            boolean found = false;
            for (ProductEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
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
        List<ProductEntity> list = productPersistence.findByName(name);

        for (ProductEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(list.size(), cache.size());
        for (ProductEntity ent : list) {
            boolean found = false;
            for (ProductEntity cacheEntity : cache) {
                if (cacheEntity.getName().equals(ent.getName())) {
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
     * Method to test getByCellPhoneNameTest
     */
    @Test
    public void getByCellPhoneNameTest() {
        String name = data.get(0).getName();
        List<ProductEntity> cache = new ArrayList<ProductEntity>();
        List<ProductEntity> list = productPersistence.getByCellPhoneName(name);

        for (ProductEntity entity : data) {
            if (entity.getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ProductEntity entity : list) {
            boolean found = false;
            for (ProductEntity cacheEntity : cache) {
                if (cacheEntity.getId().equals(entity.getId())) {
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
     * Method to test getCheaperProduct
     */
    @Test
    public void getCheaperProductTest(){
        Long id = data.get(0).getProvider().getId();
        ProductEntity entity = productPersistence.getCheaperProduct(id);
        Assert.assertNotNull(entity);
        Long price = Long.MAX_VALUE;
        ProductEntity cheapest = null;
        for(ProductEntity ent: data){
            if(ent.getCellPhone().getId().equals(id)&&entity.getPrice()<price){
                price=ent.getPrice();
                cheapest=ent;
            }
        }        
        Assert.assertEquals(cheapest.getId(), entity.getId());
    }
    
     /**
     * Test getCheaperProvider method
     */ 
    @Test
    public void getCheaperProviderTest(){
       Long id = data.get(0).getCellPhone().getId();
        ProductEntity entity = productPersistence.getCheaperProvider(id);
        Assert.assertNotNull(entity);
        Long price = Long.MAX_VALUE;
        ProductEntity cheapest = null;
        for(ProductEntity ent: data){
            if(ent.getCellPhone().getId().equals(id)&&entity.getPrice()<price){
                price=ent.getPrice();
                cheapest=ent;
            }
        }        
        Assert.assertEquals(cheapest.getId(), entity.getId());
    }
    
    /**
     * Test getByModel method
     */ 
    @Test
    public void getByModelTest(){
        String name = data.get(0).getCellPhone().getName();
        List<ProductEntity> cache = new ArrayList<ProductEntity>();
        List<ProductEntity> list = productPersistence.getByModel(name);

        for (ProductEntity entity : data) {
            if (entity.getCellPhone().getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ProductEntity entity : list) {
            Assert.assertNotNull(entity);
            boolean found = false;
            for (ProductEntity cacheEntity : cache) {
                if (cacheEntity.getId().equals(entity.getId())) {
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
     * Test getByBrand method
     */ 
    @Test
    public void getByBrandTest(){
        String name = data.get(0).getCellPhone().getBrand();
        List<ProductEntity> cache = new ArrayList<ProductEntity>();
        List<ProductEntity> list = productPersistence.getByBrand(name);

        for (ProductEntity entity : data) {
            if (entity.getCellPhone().getBrand().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ProductEntity entity : list) {
            Assert.assertNotNull(entity); 
            boolean found = false;
            for (ProductEntity cacheEntity : cache) {
                if (cacheEntity.getId().equals(entity.getId())) {
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
     * Test getByProviderName method
     */ 
    @Test
    public void getByProviderNameTest(){
        String name = data.get(0).getProvider().getName();
        List<ProductEntity> cache = new ArrayList<ProductEntity>();
        List<ProductEntity> list = productPersistence.getByProviderName(name);

        for (ProductEntity entity : data) {
            if (entity.getProvider().getName().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ProductEntity entity : list) {
            Assert.assertNotNull(entity);
            boolean found = false;
            for (ProductEntity cacheEntity : cache) {
                if (cacheEntity.getId().equals(entity.getId())) {
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
     * Test getByCity method
     */ 
    @Test
    public void getByCityTest(){
        String name = data.get(0).getProvider().getCity();
        List<ProductEntity> cache = new ArrayList<ProductEntity>();
        List<ProductEntity> list = productPersistence.getByCity(name);

        for (ProductEntity entity : data) {
            if (entity.getProvider().getCity().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ProductEntity entity : list) {
            Assert.assertNotNull(entity);
            boolean found = false;
            for (ProductEntity cacheEntity : cache) {
                if (cacheEntity.getId().equals(entity.getId())) {
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
     * Method to test getByPriceRange method
     */
    @Test
    public void getByPriceRangeTest(){
        Long minPrice =null;
        Long maxPrice = null;
        
        for(ProductEntity entity: data){
            if(minPrice==null||entity.getPrice()<minPrice)minPrice=entity.getPrice();
            if(maxPrice==null||entity.getPrice()>maxPrice)maxPrice=entity.getPrice();
        }
        List<ProductEntity> products = productPersistence.getByPriceRange(minPrice, maxPrice);
        Assert.assertNotNull(products);
        
        Assert.assertEquals(data.size(), products.size());
        for (ProductEntity entity : products) {
            Assert.assertNotNull(entity);
            boolean found = false;
            for (ProductEntity cacheEntity : data) {
                if (cacheEntity.getId().equals(entity.getId())) {
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
     * Method to test getByDiscountTest()
     */
    @Test
    public void getByDiscountTest(){
        
        List<ProductEntity> cache = new ArrayList<ProductEntity>();
        List<ProductEntity> products = productPersistence.getByDiscount();

        for (ProductEntity entity : data) {
            if (entity.getDiscount()>0) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), products.size());
        for (ProductEntity entity : products) {
            Assert.assertNotNull(entity);
            boolean found = false;
            for (ProductEntity cacheEntity : cache) {
                if (cacheEntity.getId().equals(entity.getId())) {
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
     * Method to test getByCategory 
     */
    @Test
    public void getByCategoryTest(){
        String name = data.get(0).getCategory();
        List<ProductEntity> cache = new ArrayList<ProductEntity>();
        List<ProductEntity> list = productPersistence.getByCategory(name);

        for (ProductEntity entity : data) {
            if (entity.getCategory().equals(name)) {
                cache.add(entity);
            }
        }
        Assert.assertEquals(cache.size(), list.size());
        for (ProductEntity entity : list) {
            Assert.assertNotNull(entity);
            boolean found = false;
            for (ProductEntity cacheEntity : cache) {
                if (cacheEntity.getId().equals(entity.getId())) {
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
     * Method to test getCategories
     */
    public void getCategoriesTest(){
        List<String> cache = new ArrayList<String>();
        for(ProductEntity entity: data){
            boolean found =false;
            for(String name:cache){
                if(entity.getCategory().equals(name)){
                    found=true;
                    break;
                }
            }
            if(!found)cache.add(entity.getCategory());            
        }
        List<String> list = productPersistence.getCategories();
        Assert.assertEquals(cache.size(), list.size());
        for (String category : list) {
            Assert.assertNotNull(category);
            boolean found = false;
            for (String name : cache) {
                if (name.equals(category)) {
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
     * Method to test getProductsByProvider
     */
    @Test
    public void getProductsByProviderTest(){
        Long idProvider = data.get(0).getProvider().getId();
        List<ProductEntity> cache = new ArrayList<ProductEntity>();
        for(ProductEntity entity: data){
            if(entity.getProvider().getId().equals(idProvider)){
                cache.add(entity);
            }
        }
        List<ProductEntity> list = productPersistence.getProductsByProvider(1, data.size(), idProvider);
        Assert.assertNotNull(list);
        Assert.assertEquals(cache.size(), list.size());
        for (ProductEntity entity : list) {
            Assert.assertNotNull(entity);
            boolean found = false;
            for (ProductEntity cacheEntity : cache) {
                if (entity.getId().equals(cacheEntity.getId())) {
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
     * Method to test countProductsByProvider
     */
    @Test
    public void countProductsByProviderTest(){
        Long idProvider = data.get(0).getProvider().getId();
        List<ProductEntity> cache = new ArrayList<ProductEntity>();
        for(ProductEntity entity: data){
            if(entity.getProvider().getId().equals(idProvider)){
                cache.add(entity);
            }
        }
        int count = productPersistence.getCountProductsByProvider(idProvider);
        Assert.assertEquals(cache.size(), count);
    }
    
   /**
     * Method to test getProductByImei
     */
    @Test
    public void getProductByImeiTest(){
        String imei = generateRandom(String.class);
        ProductEntity choose = null;
        for(ProductEntity entity: data){
            if(entity.getImei().equals(imei)){
                choose = entity;
            }
            ProductEntity result = productPersistence.getProductByImei(entity.getImei());
            Assert.assertNotNull(result);
            Assert.assertEquals(entity.getId(), result.getId());            
        }
        ProductEntity entity = productPersistence.getProductByImei(imei);
        if(choose==null){
            Assert.assertNull(entity.getId());
        }else{
            Assert.assertEquals(choose.getId(), entity.getId());
        }        
    }
}
