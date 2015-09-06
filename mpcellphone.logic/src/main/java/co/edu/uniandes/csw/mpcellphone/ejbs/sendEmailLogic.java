/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.ISendEmailLogic;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author g.gonzalez10
 */
public class sendEmailLogic implements ISendEmailLogic {

     @Resource(name = "mail/mailerMarketPhone")
     private Session mailSession;
     
     public int sendEmailMP (String emailTo, String subject, String msg) {

         try {
             Date timeStamp = new Date();
             
             
             Message message = new MimeMessage(mailSession);
             message.setRecipients(Message.RecipientType.TO,
                     InternetAddress.parse(emailTo, false));
             message.setSubject(subject);
             message.setText(msg);
             message.setHeader("X-Mailer", "MarketPhone");
             message.setHeader("Content-type","text/html; charset=iso-8859-1\r\n");
             message.setHeader("From", "ggonz04@gmail.com");
             message.setSentDate(timeStamp);
             Transport.send(message);
             return 0;
         } catch (MessagingException ex) {
             Logger.getLogger(sendEmailLogic.class.getName()).log(Level.SEVERE, null, ex);
             return ex.hashCode();
         }
     }

}
