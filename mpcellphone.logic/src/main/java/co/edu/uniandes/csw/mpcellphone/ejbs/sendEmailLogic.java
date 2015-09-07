/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.ISendEmailLogic;
import java.io.UnsupportedEncodingException;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.annotation.Resource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author g.gonzalez10
 */
public class sendEmailLogic implements ISendEmailLogic {

    //@Resource(name = "mail/mailerMarketPhone")
    //private Session mailSession;
     
     public void sendEmailMP (String emailFrom, String emailTo, String subject, String msg){
         try {
            InitialContext ctx = new InitialContext();
            Session mailSession = (Session) ctx.lookup("mail/mailerMarketPhone");
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject(subject);
            message.setRecipient(RecipientType.TO,
                         new InternetAddress(
                         emailTo,
                         emailTo));
            message.setFrom(new InternetAddress(
                    emailFrom,
                    emailFrom));
            //message.setFrom(new InternetAddress(mailSession.getProperty("mail.from")));             
            //InternetAddress[] address = {new InternetAddress(emailTo)};
            //message.setRecipients(Message.RecipientType.TO, address);
            message.setSentDate(new Date());
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(msg);
            //message.setText(msg);
            Transport.send(message);
         } catch (MessagingException ex) {
             Logger.getLogger(sendEmailLogic.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NamingException ex) {
             Logger.getLogger(sendEmailLogic.class.getName()).log(Level.SEVERE, null, ex);
         } catch (UnsupportedEncodingException ex) {
             Logger.getLogger(sendEmailLogic.class.getName()).log(Level.SEVERE, null, ex);
         }
     }

}
