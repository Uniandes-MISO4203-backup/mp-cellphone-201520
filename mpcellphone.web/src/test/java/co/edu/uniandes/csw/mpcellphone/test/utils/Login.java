/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.test.utils;

import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.UserDTO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Util class for the most common methods
 * @author cv.hernandez10
 */
public class Login {
    
    public static final String URLRESOURCES = "src/main/webapp";
    public static final String URLBASE = "http://localhost:8181/mpcellphone.web/webresources";
    public static final String PATH_REGISTER = "/users/register";
    public static final String PATH_LOGIN = "/users/login";
    public static final String PATH_ORDERS = "/orders";
    public static final String PATH_CART_ITEMS = "/cartItems";
    public static final int Ok = 200;
    public static final int Created = 201;
    public static final int OkWithoutContent = 204;
    private static String URLIMAGE = "http://www.seleniumhq.org/images/big-logo.png";
    
    public static void createSampleUser() {
        Client cliente = ClientBuilder.newClient();
        Response response = cliente.target(URLBASE).path(PATH_REGISTER).request().
                post(Entity.entity(Login.createSampleUserDTO(), MediaType.APPLICATION_JSON));       
    }
    
    /**
     * Login Cookie
     * @param username
     * @param password
     * @return 
     */
    public static Cookie login(String username, String password) {
        Client cliente = ClientBuilder.newClient();
        UserDTO user = new UserDTO();
        user.setUserName(username);
        user.setPassword(password);
        Response response = cliente.target(URLBASE).path(PATH_LOGIN).request().
                post(Entity.entity(user, MediaType.APPLICATION_JSON));       
        UserDTO foundUser = (UserDTO) response.readEntity(UserDTO.class);
        
        if (foundUser != null && response.getStatus() == Ok) {
            return response.getCookies().get("JSESSIONID");
        } else {
            return null;
        }
    }
    
    /**
     * Sample DTO User
     * @return 
     */
    public static UserDTO createSampleUserDTO(){
        UserDTO client = new UserDTO();
        client.setId(Long.parseLong("1"));
        client.setName("Test12");
        client.setRole("client");
        client.setStormpath("https://api.stormpath.com/v1/accounts/SfnHyNZUy4a7FQUTxXShv");
        client.setPassword("12345TesT");
        client.setEmail("test@uniandes.edu.co");
        client.setUserName("test test");
        return client;
    }
    
    /**
     * Sample Client Entity
     * @return 
     */
    public static ClientDTO createSampleClientDTO(){
        ClientDTO client = new ClientDTO();
        client.setName("Test12");
        client.setUserId("https://api.stormpath.com/v1/accounts/SfnHyNZUy4a7FQUTxXShv");
        client.setName("test");
        return client;
    }   
    
}
