/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IQuestionLogic;
import co.edu.uniandes.csw.mpcellphone.converters.QuestionConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.QuestionDTO;
import co.edu.uniandes.csw.mpcellphone.entities.QuestionEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.QuestionPersistence;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author g.gonzalez10
 */
@Stateless
public class QuestionLogic implements IQuestionLogic {
    
    // Lógica para generar el email
    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    @Inject private QuestionPersistence persistence;
    
    /**
     * Metodo encargado de obtener las órdenes de un cliente
     * @param page
     * @param maxRecords
     * @return 
     */
    @Override
    public List<QuestionDTO> getQuestions(Integer page, Integer maxRecords) {
        return QuestionConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    @Override
    public QuestionDTO getQuestion(Long id) {
        return QuestionConverter.fullEntity2DTO(persistence.find(id));
    }

    @Override
    public int countQuestion() {
        return persistence.count();
    }

    /**
     * @param dto
     * @return 
     */
    @Override
    public QuestionDTO createQuestion(QuestionDTO dto) {
        QuestionEntity entity = QuestionConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        //Send email
        String emailMsg="<html><body><br />Señor(a) "+dto.getProvider().getName() +
                "<br /><br />" +
                "Usted ha recibido una nueva pregunta: <br /><br /> " +
                "<br />Producto: " + dto.getProduct().getName() + 
                "<br />Cliente: " + dto.getClient().getName() + 
                "<br />Pregunta: "+entity.getQuestion() +
                "<br /><br />Atentamente," + 
                "<br /><br /><br />MarketPhone";
        String subject = "Ha reibido un mensaje de MarketPhone";
        generateAndSendEmail(emailMsg, dto.getProvider().getEmail(), subject);
        return QuestionConverter.fullEntity2DTO(entity);
    }

    public static void generateAndSendEmail(String message, String emailRecipient, String subject) {
        try {
            
            //Step1		
            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");

            //Step2		
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailRecipient));
            generateMailMessage.setSubject(subject);
            String emailBody = message;
            generateMailMessage.setContent(emailBody, "text/html");

            //Step3		
            Transport transport = getMailSession.getTransport("smtp");

            // Enter your correct gmail UserID and Password (XXXApp Shah@gmail.com)
            transport.connect("smtp.gmail.com", "marketphone201520@gmail.com", "Market2015");
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();
            
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
}
