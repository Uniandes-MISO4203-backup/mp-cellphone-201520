/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.api.IShipLogic;
import co.edu.uniandes.csw.mpcellphone.converters.ShipConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.ShipDTO;
import co.edu.uniandes.csw.mpcellphone.ejbs.ShipLogic;
import co.edu.uniandes.csw.mpcellphone.entities.ShipEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.ShipPersistence;
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
public class ShipLogicTest {
    public static final String DEPLOY = "Prueba";

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ShipEntity.class.getPackage())
                .addPackage(ShipDTO.class.getPackage())
                .addPackage(ShipConverter.class.getPackage())
                .addPackage(ShipLogic.class.getPackage())
                .addPackage(IShipLogic.class.getPackage())
                .addPackage(ShipPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private IShipLogic shipLogic;
    
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
        em.createQuery("delete from ShipEntity").executeUpdate();
    }

    private List<ShipEntity> data = new ArrayList<ShipEntity>();
    /**
     * @generated
     */
    private void insertData() {
        String state = generateRandom(String.class);
        String country = generateRandom(String.class);
        String city = generateRandom(String.class);
        for (int i = 0; i < 3; i++) {
            ShipEntity entityU = new ShipEntity();
        	entityU.setState(state);
        	entityU.setCountry(country);
                entityU.setCity(city);
            em.persist(entityU);
            data.add(entityU);
        }
    }

    @Test
    public void countShipTest(){
        int size = shipLogic.countShip();
        Assert.assertEquals(data.size(), size);
    }

    @Test
    public void getShipsTest() {
        List<ShipDTO> list = shipLogic.getShips(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ShipDTO dto : list) {
            boolean found = false;
            for (ShipEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getShipTest() {
        ShipEntity entity = data.get(0);
        ShipDTO dto = shipLogic.getShip(entity.getId());
        Assert.assertEquals(entity.getState(), dto.getState());
        Assert.assertEquals(entity.getCountry(), dto.getCountry());
        Assert.assertEquals(entity.getCity(), dto.getCity());
    }

    @Test
    public void createShipTest() {
        String state = generateRandom(String.class);
        String country = generateRandom(String.class);
        String city = generateRandom(String.class);
        
        ShipDTO dto = new ShipDTO();
        dto.setState(state);
        dto.setCountry(country);
        dto.setCity(city);

        ShipDTO result = shipLogic.createShip(dto);

        Assert.assertNotNull(result);

        ShipEntity entity = em.find(ShipEntity.class, result.getId());

        Assert.assertEquals(dto.getState(), entity.getState());
        Assert.assertEquals(dto.getCountry(), entity.getCountry());
        Assert.assertEquals(dto.getCity(), entity.getCity());
    }

    @Test
    public void updateShipTest() {
        String state = generateRandom(String.class);
        String country = generateRandom(String.class);
        String city = generateRandom(String.class);
        
        ShipEntity entity = data.get(0);
        
        ShipDTO dto = new ShipDTO();
        dto.setId(entity.getId());
        dto.setState(state);
        dto.setCountry(country);
        dto.setCity(city);
        
        ShipDTO updDto = shipLogic.updateShip(dto);
        
        Assert.assertNotNull(updDto);

        Assert.assertEquals(updDto.getState(), state);
        Assert.assertEquals(updDto.getCountry(), country);
        Assert.assertEquals(updDto.getCity(), city);
        
    }
    
    @Test
    public void deleteShipTest() {
        ShipEntity entity = data.get(0);
        shipLogic.deleteShip(entity.getId());
        ShipEntity deleted = em.find(ShipEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

}
