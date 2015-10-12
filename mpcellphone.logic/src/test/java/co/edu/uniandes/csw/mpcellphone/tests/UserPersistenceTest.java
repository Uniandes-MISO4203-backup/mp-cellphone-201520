package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.entities.ProviderEntity;
import co.edu.uniandes.csw.mpcellphone.entities.UserEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.ProviderPersistence;
import co.edu.uniandes.csw.mpcellphone.persistence.UserPersistence;
import static co.edu.uniandes.csw.mpcellphone.tests.ProviderPersistenceTest.DEPLOY;
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
    private List<UserEntity> data = new ArrayList<UserEntity>();
    public static final String DEPLOY = "Prueba";
    
    @Inject
    private UserPersistence userPersistence;
    
    @Test
    public void getUserTest() {
        UserEntity entity = data.get(0);
        UserEntity newEntity = userPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ProviderEntity.class.getPackage())
                .addPackage(ProviderPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
/*
        public UserEntity getUsers(String userId){
        try {
            return this.executeSingleNamedQuery("User.FindAll");
        } catch (NoResultException e) {
            return null;
        }
    }
    */
    /**
     * @generated
     */
    
}
