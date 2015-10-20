package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.entities.UserEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.UserPersistence;
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
public class UserPersistenceTest {
    public static final String DEPLOY = "Prueba";
    
    @Inject
    private UserPersistence userPersistence;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(UserEntity.class.getPackage())
                .addPackage(UserPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**    /**
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
        em.createQuery("delete from UserEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<UserEntity> data = new ArrayList<UserEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            UserEntity entity = new UserEntity();
            entity.setName(generateRandom(String.class));
            entity.setStormpath(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * @generated
     */
    @Test
    public void createUserTest() {
        UserEntity newEntity = new UserEntity();
        newEntity.setName(generateRandom(String.class));
        newEntity.setStormpath(generateRandom(String.class));

        UserEntity result = userPersistence.create(newEntity);

        Assert.assertNotNull(result);

        UserEntity entity = em.find(UserEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getStormpath(), entity.getStormpath());
    }

    /*
    @Test
    public void getUserTest() {
        UserEntity entity = data.get(0);
        UserEntity newEntity = userPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }
    */
    
}
