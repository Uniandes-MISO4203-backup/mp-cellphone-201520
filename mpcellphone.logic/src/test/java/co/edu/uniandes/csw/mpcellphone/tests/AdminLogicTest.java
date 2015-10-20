/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.IAdminLogic;
import co.edu.uniandes.csw.mpcellphone.api.IUserLogic;
import co.edu.uniandes.csw.mpcellphone.converters.AdminConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.AdminDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.UserDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.AdminLogic;
import co.edu.uniandes.csw.mpcellphone.entities.AdminEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.AdminPersistence;
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
public class AdminLogicTest {
    public static final String DEPLOY = "Prueba";

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(AdminEntity.class.getPackage())
                .addPackage(AdminDTO.class.getPackage())
                .addPackage(AdminConverter.class.getPackage())
                .addPackage(AdminLogic.class.getPackage())
                .addPackage(IAdminLogic.class.getPackage())
                .addPackage(AdminPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private IAdminLogic adminLogic;
    
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
        em.createQuery("delete from AdminEntity").executeUpdate();
    }

    private List<AdminEntity> data = new ArrayList<AdminEntity>();
    /**
     * @generated
     */
    private void insertData() {
        String name = generateRandom(String.class);
        String email = generateRandom(String.class);
        for (int i = 0; i < 3; i++) {
            AdminEntity entityU = new AdminEntity();
        	entityU.setName(name);
                entityU.setEmail(email);
            em.persist(entityU);
            data.add(entityU);
        }
    }
    
    @Test
    public void createAdminTest() {
        String name = generateRandom(String.class);
        String email = generateRandom(String.class);
        String userName = generateRandom(String.class);
        
        UserDTO dtoUser = new UserDTO();
        dtoUser.setName(userName);
        
        UserDTO resultUser = userLogic.createUser(dtoUser);   
        
        AdminDTO dto = new AdminDTO();
        dto.setName(name);
        dto.setEmail(email);
        dto.setUser(resultUser);
        AdminDTO result = adminLogic.createAdmin(dto);
        Assert.assertNotNull(result);
        AdminEntity entity = em.find(AdminEntity.class, result.getId());
        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getEmail(), entity.getEmail());
    }
    

    @Test
    public void countAdminsTest(){
        int size = adminLogic.countAdmins();
        Assert.assertEquals(data.size(), size);
    }
    
    @Test
    public void getAdminsTest() {
        List<AdminDTO> list = adminLogic.getAdmins(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (AdminDTO dto : list) {
            boolean found = false;
            for (AdminEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getAdminTest() {
        AdminEntity entity = data.get(0);
        AdminDTO dto = adminLogic.getAdmin(entity.getId());
        Assert.assertEquals(entity.getName(), dto.getName());
    }    
    
    @Test
    public void updateAdminTest() {
        String name = generateRandom(String.class);
        String email = generateRandom(String.class);
        String userName = generateRandom(String.class);
        
        AdminEntity entity = data.get(0);
        
        UserDTO dtoUser = new UserDTO();
        dtoUser.setName(userName);
        
        UserDTO resultUser = userLogic.createUser(dtoUser);   
        
        
        AdminDTO dto = new AdminDTO();
        dto.setId(entity.getId());
        dto.setName(name);
        dto.setUser(resultUser);
        dto.setEmail(email);
        
        AdminDTO updDto = adminLogic.updateAdmin(dto);
        //AdminDTO updDto = dto;
        
        Assert.assertNotNull(updDto);

        Assert.assertEquals(updDto.getName(), name);
        Assert.assertEquals(updDto.getEmail(), email);
        Assert.assertEquals(updDto.getUser().getName(), userName);
        
    }

    @Test
    public void deleteAdminTest() {
        AdminEntity entity = data.get(0);
        adminLogic.deleteAdmin(entity.getId());
        AdminEntity deleted = em.find(AdminEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

}
