package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.IPhotoLogic;
import co.edu.uniandes.csw.mpcellphone.converters.PhotoConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.PhotoDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.PhotoLogic;
import co.edu.uniandes.csw.mpcellphone.entities.PhotoEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.PhotoPersistence;
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
public class PhotoLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PhotoEntity.class.getPackage())
                .addPackage(PhotoDTO.class.getPackage())
                .addPackage(PhotoConverter.class.getPackage())
                .addPackage(PhotoLogic.class.getPackage())
                .addPackage(IPhotoLogic.class.getPackage())
                .addPackage(PhotoPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IPhotoLogic photoLogic;

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
    }

    /**
     * @generated
     */
    private List<PhotoEntity> data = new ArrayList<PhotoEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PhotoEntity entity = new PhotoEntity();
            entity.setName(generateRandom(String.class));
            entity.setImage(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createPhotoTest() {
        PhotoDTO dto = new PhotoDTO();
        dto.setName(generateRandom(String.class));
        dto.setImage(generateRandom(String.class));

        PhotoDTO result = photoLogic.createPhoto(dto);

        Assert.assertNotNull(result);

        PhotoEntity entity = em.find(PhotoEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getPhotosTest() {
        List<PhotoDTO> list = photoLogic.getPhotos(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (PhotoDTO dto : list) {
            boolean found = false;
            for (PhotoEntity entity : data) {
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
    public void getPhotoTest() {
        PhotoEntity entity = data.get(0);
        PhotoDTO dto = photoLogic.getPhoto(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
    }
    
    /**
     * @generated
     */
    @Test
    public void getPhotosPaginationTest() {
        //Page 1
        List<PhotoDTO> dto1 = photoLogic.getPhotos(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<PhotoDTO> dto2 = photoLogic.getPhotos(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (PhotoDTO dto : dto1) {
            boolean found = false;
            for (PhotoEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (PhotoDTO dto : dto2) {
            boolean found = false;
            for (PhotoEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Test countPhotos method
     */ 
    @Test
    public void countCitiesTest(){
        Assert.assertEquals(data.size(), photoLogic.countPhotos()); 
    }
    
    /**
     * @generated
     */
    @Test
    public void updatePhotoTest() {
        PhotoEntity entity = data.get(0);

        PhotoDTO dto = new PhotoDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setImage(generateRandom(String.class));

        photoLogic.updatePhoto(dto);

        PhotoEntity resp = em.find(PhotoEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getImage(), resp.getImage());
    }
    
    /**
     * @generated
     */
    @Test
    public void deleteCellPhoneTest() {
        PhotoEntity entity = data.get(0);
        photoLogic.deletePhoto(entity.getId());
        PhotoEntity deleted = em.find(PhotoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
