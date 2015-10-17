/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.converters.PhotoConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.PhotoDTO;
import co.edu.uniandes.csw.mpcellphone.entities.PhotoEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.PhotoPersistence;
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
 *
 * @author Mauro
 */
@RunWith(Arquillian.class) 
public class PhotoPersistenceTest {
    /**
     * @generated
     */
    public static final String DEPLOY = "Prueba";
    
    /**
     * @generated
     */
    @Inject 
    UserTransaction utx; 
    
    
    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;
    
    /**
     * @generated
     */
    @Inject
    private PhotoPersistence photoPersistence;
    
    private List<PhotoEntity> data = new ArrayList(); 
    
    /**
     * @return 
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(PhotoEntity.class.getPackage())
                .addPackage(PhotoPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
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
    private void insertData() { 
        for (int i = 0; i < 3; i++) { 
            PodamFactory factory = new PodamFactoryImpl(); 
            PhotoEntity entity = PhotoConverter.basicDTO2Entity(factory.manufacturePojo(PhotoDTO.class)); 
            em.persist(entity); 
            data.add(entity); 
        } 
    }
    
    /**
     * @generated
     */
    @Test
    public void createPhotoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        PhotoEntity newEntity = PhotoConverter.basicDTO2Entity(factory.manufacturePojo(PhotoDTO.class));

        PhotoEntity result = photoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PhotoEntity entity = em.find(PhotoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    /**
     * @generated
     */
    @Test
    public void getPhotoTest() {
        PhotoEntity entity = data.get(0);
        PhotoEntity newEntity = photoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
    /**
     * @generated
     */
    @Test
    public void deletePhotoTest() {
        PhotoEntity entity = data.get(0);
        photoPersistence.delete(entity.getId());
        PhotoEntity deleted = em.find(PhotoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updatePhotoTest() {
        PhotoEntity entity = data.get(0);

        PodamFactory factory = new PodamFactoryImpl();
        PhotoEntity newEntity = PhotoConverter.basicDTO2Entity(factory.manufacturePojo(PhotoDTO.class));
        newEntity.setId(entity.getId());

        photoPersistence.update(newEntity);

        PhotoEntity resp = em.find(PhotoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
    
    /**
     * @generated
     */
    @Test
    public void getPhotosTest() {
        List<PhotoEntity> list = photoPersistence.findAll(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (PhotoEntity ent : list) {
            boolean found = false;
            for (PhotoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    
}
