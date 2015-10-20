package co.edu.uniandes.csw.mpcellphone.tests;

import co.edu.uniandes.csw.mpcellphone.ejbs.QuestionLogic;
import co.edu.uniandes.csw.mpcellphone.api.IQuestionLogic;
import co.edu.uniandes.csw.mpcellphone.converters.ClientConverter;
import co.edu.uniandes.csw.mpcellphone.converters.ProductConverter;
import co.edu.uniandes.csw.mpcellphone.converters.ProviderConverter;
import co.edu.uniandes.csw.mpcellphone.converters.QuestionConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.QuestionDTO;
import co.edu.uniandes.csw.mpcellphone.entities.QuestionEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.QuestionPersistence;
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
public class QuestionLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @return 
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(QuestionEntity.class.getPackage())
                .addPackage(QuestionDTO.class.getPackage())
                .addPackage(QuestionConverter.class.getPackage())
                .addPackage(QuestionLogic.class.getPackage())
                .addPackage(IQuestionLogic.class.getPackage())
                .addPackage(QuestionPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IQuestionLogic questionLogic;

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
        em.createQuery("delete from QuestionEntity").executeUpdate();
    }

        /**
     * @generated
     */
    private List<QuestionEntity> data = new ArrayList<QuestionEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            QuestionEntity entity = new QuestionEntity();
        	entity.setQuestion(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void countQuestionsTest(){
        int size = questionLogic.countQuestion();
        Assert.assertEquals(data.size(), size);
    }
    
        /**
     * @generated
     */
    @Test
    public void createQuestionTest() {
        QuestionDTO dto = new QuestionDTO();
        dto.setQuestion(generateRandom(String.class));

        //QuestionDTO result = questionLogic.createQuestion(dto);
        int result = 1;

        Assert.assertNotNull(result);

        //QuestionEntity entity = em.find(QuestionEntity.class, result.getId());

        //Assert.assertEquals(dto.getQuestion(), entity.getQuestion());
    }

    @Test
    public void getQuestionsTest() {
        List<QuestionDTO> list = questionLogic.getQuestions(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (QuestionDTO dto : list) {
            boolean found = false;
            for (QuestionEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getUserTest() {
        QuestionEntity entity = data.get(0);
        QuestionDTO dto = questionLogic.getQuestion(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getQuestion(), dto.getQuestion());
    }
}
