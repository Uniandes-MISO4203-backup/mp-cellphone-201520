/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.persistence;

import co.edu.uniandes.csw.mpcellphone.entities.QuestionEntity;

/**
 *
 * @author g.gonzalez10
 */
public class QuestionPersistence extends CrudPersistence<QuestionEntity> {

    public QuestionPersistence() {
        this.entityClass = QuestionEntity.class;
    }
    
}
