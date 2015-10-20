/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.dtos.UserDTO;
import co.edu.uniandes.csw.mpcellphone.entities.UserEntity;
import static co.edu.uniandes.csw.mpcellphone.tests._TestUtil.generateRandom;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author g.gonzalez10
 */
@RunWith(Arquillian.class)
public class UserConverterTest {
    public static final String DEPLOY = "Prueba";
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(UserEntity.class.getPackage())
                .addPackage(UserDTO.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Test
    public void refEntity2DTOTest() {
        UserEntity newEntity = new UserEntity();
        
        newEntity.setName(generateRandom(String.class));
        newEntity.setRole(generateRandom(String.class));
        newEntity.setEmail(generateRandom(String.class));
               
        UserDTO dto = new UserDTO();
        
        dto.setName(newEntity.getName());
        dto.setRole(newEntity.getRole());
        dto.setEmail(newEntity.getEmail());

        Assert.assertEquals(newEntity.getName(), dto.getName());
        Assert.assertEquals(newEntity.getRole(), dto.getRole());
        Assert.assertEquals(newEntity.getEmail(), dto.getEmail());
      
    }

    @Test
    public void refDTO2EntityTest(){
        UserDTO dto = new UserDTO();
        
        dto.setId(generateRandom(Long.class));
        
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        
        Assert.assertEquals(entity.getId(), dto.getId());
        
    }
    
}
