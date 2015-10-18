/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.IUserLogic;
import co.edu.uniandes.csw.mpcellphone.converters.UserConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.UserDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.UserLogic;
import co.edu.uniandes.csw.mpcellphone.entities.UserEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.UserPersistence;
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
 * @author g.gonzalez10
 */
@RunWith(Arquillian.class)
public class UserLogicTest {
    public static final String DEPLOY = "Prueba";

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(UserEntity.class.getPackage())
                .addPackage(UserDTO.class.getPackage())
                .addPackage(UserConverter.class.getPackage())
                .addPackage(UserLogic.class.getPackage())
                .addPackage(IUserLogic.class.getPackage())
                .addPackage(UserPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private IUserLogic userLogic;
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

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

    private void clearData() {
        em.createQuery("delete from UserEntity").executeUpdate();
    }

    private List<UserEntity> data = new ArrayList<UserEntity>();
    /**
     * @generated
     */
    private void insertData() {
        String name = generateRandom(String.class);
        String role = generateRandom(String.class);
        String email = generateRandom(String.class);
        for (int i = 0; i < 3; i++) {
            UserEntity entityU = new UserEntity();
        	entityU.setName(name);
        	entityU.setRole(role);
                entityU.setEmail(email);
            em.persist(entityU);
            data.add(entityU);
        }
    }

    @Test
    public void createUserTest() {
        String name = generateRandom(String.class);
        String role = generateRandom(String.class);
        String email = generateRandom(String.class);
        
        UserDTO dto = new UserDTO();
        dto.setName(name);
        dto.setRole(role);
        dto.setEmail(email);

        UserDTO result = userLogic.createUser(dto);

        Assert.assertNotNull(result);

        UserEntity entity = em.find(UserEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getRole(), entity.getRole());
        Assert.assertEquals(dto.getEmail(), entity.getEmail());
    }

    @Test
    public void countUsersTest(){
        int size = userLogic.countUsers();
        Assert.assertEquals(data.size(), size);
    }
    
   
    @Test
    public void getUsersTest() {
        List<UserDTO> list = userLogic.getUsers(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (UserDTO dto : list) {
            boolean found = false;
            for (UserEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void updateUserTest() {
        String name = generateRandom(String.class);
        String role = generateRandom(String.class);
        String email = generateRandom(String.class);
        
        UserEntity entity = data.get(0);
        
        UserDTO dto = userLogic.getUserByUserId(entity.getStormpath());
        dto.setName(name);
        dto.setRole(role);
        dto.setEmail(email);
        
        UserDTO updDto = userLogic.updateUser(dto);
        
        Assert.assertNotNull(updDto);

        Assert.assertEquals(updDto.getName(), name);
        Assert.assertEquals(updDto.getRole(), role);
        Assert.assertEquals(updDto.getEmail(), email);
        
    }
    
    @Test
    public void deleteUserTest() {
        UserEntity entity = data.get(0);
        userLogic.deleteUser(entity.getId());
        UserEntity deleted = em.find(UserEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
