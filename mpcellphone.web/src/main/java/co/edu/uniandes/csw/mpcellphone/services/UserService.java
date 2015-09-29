/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.services;

import co.edu.uniandes.csw.mpcellphone.api.IAdminLogic;
import co.edu.uniandes.csw.mpcellphone.api.IClientLogic;
import co.edu.uniandes.csw.mpcellphone.api.IProviderLogic;
import co.edu.uniandes.csw.mpcellphone.api.IUserLogic;
import co.edu.uniandes.csw.mpcellphone.dtos.AdminDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ClientDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.ProviderDTO;
import co.edu.uniandes.csw.mpcellphone.dtos.UserDTO;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.account.AccountStatus;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.group.Group;
import com.stormpath.sdk.group.GroupList;
import com.stormpath.sdk.resource.ResourceException;
import com.stormpath.shiro.realm.ApplicationRealm;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author Jhonatan
 * 
 * jbdel10: Se agrega la logica para Admin
 * 
 */
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

    @Inject
    private IClientLogic clientLogic;

    @Inject
    private IProviderLogic providerLogic;

    @Inject
    private IAdminLogic adminLogic;
    

    @Inject private IUserLogic userLogic;
    @Context private HttpServletResponse respon;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    @Path("/login")
    @POST
    public Response login(UserDTO user) {
        
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword(), user.isRememberMe());
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.login(token);
            
            ClientDTO client = clientLogic.getClientByUserId(currentUser.getPrincipal().toString());
            if (client != null) {
                currentUser.getSession().setAttribute("Client", client);
                return Response.ok(client).build();
            } else {
                ProviderDTO provider = providerLogic.getProviderByUserId(currentUser.getPrincipal().toString());
                if (provider != null) {
                    currentUser.getSession().setAttribute("Provider", provider);
                    return Response.ok(provider).build();
                } else {
                    //jbdel1
                    AdminDTO admin = adminLogic.getAdminByUserId(currentUser.getPrincipal().toString());
                    if (admin != null) {
                        currentUser.getSession().setAttribute("Admin", admin);
                        return Response.ok(admin).build();
                    } else {
                        return Response.status(Response.Status.BAD_REQUEST)
                                .entity(" User is not registered")
                                .type(MediaType.TEXT_PLAIN)
                                .build();
                    }                
                }
            }
                
        } catch (AuthenticationException e) 
        {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }    
    }

    @Path("/logout")
    @GET
    public Response logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/currentUser")
    @GET
    public Response getCurrentUser() {
        UserDTO user = new UserDTO();
        try {
            Subject currentUser = SecurityUtils.getSubject();
            Map<String, String> userAttributes = (Map<String, String>) currentUser.getPrincipals().oneByType(java.util.Map.class);
            user.setName(userAttributes.get("givenName") + " " + userAttributes.get("surname"));
            user.setEmail(userAttributes.get("email"));
            user.setUserName(userAttributes.get("username"));
            user.setRole(userLogic.getUserByUserName(user.getUserName()).getRole());
            
            switch (user.getRole()) {
                case "client":
                    user.setId(clientLogic.getClientByEmail(user.getEmail()).getId());
                    break;
                case "provider":
                    //user.setId(providerLogic.getProviderByEmail(user.getEmail()).getId());
                    break;
            }
            return Response.ok(user).build();
        } catch (AuthenticationException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    private Account createUser(UserDTO user) {
    
        ApplicationRealm realm = ((ApplicationRealm) ((RealmSecurityManager) SecurityUtils.getSecurityManager()).getRealms().iterator().next());
        Client client = realm.getClient();
        Application application = client.getResource(realm.getApplicationRestUrl(), Application.class);
        Account acct = client.instantiate(Account.class);
        acct.setUsername(user.getUserName());
        acct.setPassword(user.getPassword());
        acct.setEmail(user.getEmail());
        acct.setGivenName(user.getName());
        acct.setSurname(user.getName());
        acct.setStatus(AccountStatus.ENABLED);
        GroupList groups = application.getGroups();
        for (Group grp : groups) {
            if (grp.getName().equals(user.getRole())) {
                acct = application.createAccount(acct);
                acct.addGroup(grp);
                break;
            }
        }
        return acct;
    }
        
    @Path("/register")
    @POST
    public Response setUser(UserDTO user) {

        try {
            switch (user.getRole()) {
                case "user":
                    Account acctClient = this.createUser(user);
                    ClientDTO newClient = new ClientDTO();
                    newClient.setName(user.getUserName());
                    newClient.setUserId(acctClient.getHref());
                    newClient.setEmail(acctClient.getEmail());
                    newClient = clientLogic.createClient(newClient);
                    break;

                case "provider":
                    Account acctProvider = this.createUser(user);
                    ProviderDTO newProvider = new ProviderDTO();
                    newProvider.setName(user.getUserName());
                    newProvider.setUserId(acctProvider.getHref());
                    newProvider.setEmail(acctProvider.getEmail());
                    newProvider = providerLogic.createProvider(newProvider);
                    break;  
                //jdelchiaro -- 09/09/2015
                case "admin":
                    Account acctAdmin = this.createUser(user);
                    AdminDTO newAdmin = new AdminDTO();
                    newAdmin.setName(user.getUserName());
                    //newAdmin.setUserId(acctAdmin.getHref());
                    newAdmin.setEmail(acctAdmin.getEmail());
                    newAdmin = adminLogic.createAdmin(newAdmin);                    
                    break;
                
            }
            return Response.ok().build();
        } catch (ResourceException e) {
            return Response.status(e.getStatus())
                    .entity(e.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }
    
    @Path("/AllUsers")    
    @GET
    public List<UserDTO> getUsers(UserDTO user) {
      
        List<UserDTO> listUsers;
        
        //if (user.getRole() == "admin") {
                                
            if (page != null && maxRecords != null) {
                this.respon.setIntHeader("X-Total-Count", userLogic.countUsers());
            }
            listUsers = userLogic.getUsers(page, maxRecords);
            
            return listUsers;    
            
       /* } else {
            return null;
        }*/
    }


        
}
