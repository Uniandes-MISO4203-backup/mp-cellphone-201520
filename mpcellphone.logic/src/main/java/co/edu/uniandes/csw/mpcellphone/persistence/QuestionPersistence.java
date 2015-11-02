/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.QuestionEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;

/**
 *
 * @author g.gonzalez10
 */
public class QuestionPersistence extends CrudPersistence<QuestionEntity> {

    public QuestionPersistence() {
        this.entityClass = QuestionEntity.class;
    }

    public List<QuestionEntity> getByProviderId(Long idProvider) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("idProvider", idProvider);
            return executeListNamedQuery("Question.getByProviderId", params);
        } catch (NoResultException e) {
            Logger.getLogger(ProductPersistence.class.getName()).log(Level.SEVERE, null, e);
            return new ArrayList<QuestionEntity>();
        }
    }

}
