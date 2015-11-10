/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.ejbs.SaleLogic;
import co.edu.uniandes.csw.mpcellphone.api.ISaleLogic;
import co.edu.uniandes.csw.mpcellphone.converters.ClientConverter;
import co.edu.uniandes.csw.mpcellphone.converters.OrderConverter;
import co.edu.uniandes.csw.mpcellphone.converters.ProviderConverter;
import co.edu.uniandes.csw.mpcellphone.converters.SalesConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.CellPhoneDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.OrderDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.PaymentMethodDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.PhotoDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProductDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProviderDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.SaleDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ShipDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.TaxDTO;
import co.edu.uniandes.csw.mpcellphone.entities.CellPhoneEntity;
import co.edu.uniandes.csw.mpcellphone.entities.ClientEntity;
import co.edu.uniandes.csw.mpcellphone.entities.OrderEntity;
import co.edu.uniandes.csw.mpcellphone.entities.PaymentMethodEntity;
import co.edu.uniandes.csw.mpcellphone.entities.PhotoEntity;
import co.edu.uniandes.csw.mpcellphone.entities.ProductEntity;
import co.edu.uniandes.csw.mpcellphone.entities.ProviderEntity;
import co.edu.uniandes.csw.mpcellphone.entities.SalesEntity;
import co.edu.uniandes.csw.mpcellphone.entities.ShipEntity;
import co.edu.uniandes.csw.mpcellphone.entities.TaxEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.SalePersistence;
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
 *
 * @author g.gonzalez10
 */
@RunWith(Arquillian.class)
public class SaleLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(CellPhoneEntity.class.getPackage())
                .addPackage(ClientEntity.class.getPackage())
                .addPackage(OrderEntity.class.getPackage())
                .addPackage(PaymentMethodEntity.class.getPackage())
                .addPackage(PhotoEntity.class.getPackage())
                .addPackage(ProductEntity.class.getPackage())
                .addPackage(ProviderEntity.class.getPackage())
                .addPackage(SalesEntity.class.getPackage())
                .addPackage(ShipEntity.class.getPackage())
                .addPackage(TaxEntity.class.getPackage())
                .addPackage(CellPhoneDTO.class.getPackage())
                .addPackage(ClientDTO.class.getPackage())
                .addPackage(OrderDTO.class.getPackage())
                .addPackage(PaymentMethodDTO.class.getPackage())
                .addPackage(PhotoDTO.class.getPackage())
                .addPackage(ProductDTO.class.getPackage())
                .addPackage(ProviderDTO.class.getPackage())
                .addPackage(SaleDTO.class.getPackage())
                .addPackage(ShipDTO.class.getPackage())
                .addPackage(TaxDTO.class.getPackage())
                .addPackage(SaleDTO.class.getPackage())
                .addPackage(SalesConverter.class.getPackage())
                .addPackage(SaleLogic.class.getPackage())
                .addPackage(ISaleLogic.class.getPackage())
                .addPackage(SalePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ISaleLogic saleLogic;

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
        em.createQuery("delete from SalesEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<SalesEntity> data = new ArrayList<SalesEntity>();
    /**
     * @generated
     */
    private void insertData() {
        String nameC = generateRandom(String.class);
        String userIdC = generateRandom(String.class);
        String emailC = generateRandom(String.class);
        String nameP = generateRandom(String.class);
        String userIdP = generateRandom(String.class);
        String emailP = generateRandom(String.class);
        String namePr = generateRandom(String.class);
        Long price = generateRandom(Long.class);
        String totalSale = generateRandom(String.class);
        String state = generateRandom(String.class);
        String country = generateRandom(String.class);
        String method = generateRandom(String.class);
        String tax = generateRandom(String.class);
        for (int i = 0; i < 3; i++) {
            PaymentMethodEntity entityM = new PaymentMethodEntity();
        	entityM.setMethodName(method);
            em.persist(entityM);
            TaxEntity entityT = new TaxEntity();
        	entityT.setTaxName(tax);
            em.persist(entityT);
            ShipEntity entityS = new ShipEntity();
        	entityS.setCountry(country);
        	entityS.setState(state);
            em.persist(entityS);
            ClientEntity entityC = new ClientEntity();
        	entityC.setName(nameC);
        	entityC.setUserId(userIdC);
        	entityC.setEmail(emailC);
            em.persist(entityC);
            OrderEntity entityO = new OrderEntity();
        	entityO.setTotalSale(totalSale);
                entityO.setClient(entityC);
            em.persist(entityO);
            CellPhoneEntity entityCP = new CellPhoneEntity();
                entityCP.setName(namePr);
            em.persist(entityCP);
            PhotoEntity entityPH = new PhotoEntity();
                entityPH.setName(namePr);
            em.persist(entityPH);
            List<PhotoEntity> listPH = new ArrayList<PhotoEntity>();
            listPH.add(entityPH);
            ProductEntity entityPr = new ProductEntity();
        	entityPr.setName(namePr);
        	entityPr.setPrice(price);
                entityPr.setCellPhone(entityCP);
                entityPr.setPhotos(listPH);
            em.persist(entityPr);
            List<ProductEntity> listPr = new ArrayList<ProductEntity>();
            listPr.add(entityPr);
            ProviderEntity entityP = new ProviderEntity();
        	entityP.setName(nameP);
        	entityP.setUserId(userIdP);
        	entityP.setEmail(emailP);
                entityP.setProducts(listPr);
            em.persist(entityP);
            SalesEntity entity = new SalesEntity();
        	entity.setClientId(entityC);
        	entity.setOrderId(entityO);
        	entity.setProductId(entityPr);
                entity.setProviderId(entityP);
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void countSaleTest(){
        int size = saleLogic.countSale();
        Assert.assertEquals(data.size(), size);
    }

    @Test
    public void getSalesTest() {
        List<SaleDTO> list = saleLogic.getSales(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (SaleDTO dto : list) {
            boolean found = false;
            for (SalesEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getSaleTest() {
        SalesEntity entity = data.get(0);
        SaleDTO dto = saleLogic.getSale(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getClientId().getName(), dto.getClientId().getName());
    }
    
    @Test
    public void createSaleTest() {
        ClientEntity entityC = data.get(0).getClientId();
        ProviderEntity entityPr = data.get(0).getProviderId();
        OrderEntity entityO = data.get(0).getOrderId();
        SaleDTO dto = new SaleDTO();
            dto.setClientId(ClientConverter.fullEntity2DTO(entityC));
            dto.setProviderId(ProviderConverter.fullEntity2DTO(entityPr));
            dto.setOrderId(OrderConverter.fullEntity2DTO(entityO));

        SaleDTO result = saleLogic.createSale(dto);

        Assert.assertNotNull(result);

        SalesEntity entity = em.find(SalesEntity.class, result.getId());

        Assert.assertEquals(dto.getClientId().getName(), entity.getClientId().getName());
        Assert.assertEquals(dto.getProviderId().getUserId(), entity.getProviderId().getUserId());
    }
    
    @Test
    public void getSaleByClientTest() {
        Long idClient = data.get(0).getClientId().getId();
        List<SaleDTO> list = saleLogic.getSaleByClient(null, null,idClient);
        Assert.assertEquals(1, list.size());
    }
    
    @Test
    public void getSaleByProviderTest() {
        Long idProvider = data.get(0).getProviderId().getId();
        List<SaleDTO> list = saleLogic.getSaleByProvider(null, null,idProvider);
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void getProductsBySaleTest() {
        Long idClient = data.get(0).getClientId().getId();
        Long idOrder = data.get(0).getOrderId().getId();
        List<ProductDTO> list = saleLogic.getProductsBySale(null, null,idClient, idOrder);
        Assert.assertEquals(1, list.size());
    }
    
      /**
     * Update rate product test
     */
    @Test
    public void updateSalesTest() {
        
        SalesEntity entity = data.get(0);
            
        SaleDTO dto = SalesConverter.refEntity2DTO(entity);
        Assert.assertNotNull(dto);
        
        SaleDTO saleUpdated = saleLogic.updateSale(dto);

        Assert.assertNotNull(saleUpdated);
        Assert.assertEquals(entity.getId(), saleUpdated.getId());
        Assert.assertEquals(entity.getClientId().getId(), saleUpdated.getClientId().getId());
    }
    
    @Test
    public void deleteLogicTest() {
        SalesEntity entity = data.get(0);
        saleLogic.deleteSale(entity.getId());
        ShipEntity deleted = em.find(ShipEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

}
