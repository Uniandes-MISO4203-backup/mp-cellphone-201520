/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.api;

/**
 *
 * @author g.gonzalez10
 */
public interface ISendEmailLogic {

    public void sendEmailMP (String emailFrom, String emailTo, String subject, String msg);
}
