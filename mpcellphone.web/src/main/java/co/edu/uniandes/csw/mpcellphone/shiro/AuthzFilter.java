/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.shiro;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

/**
 *
 * @author Jonatan
 */
public class AuthzFilter extends RolesAuthorizationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        ((HttpServletResponse)response).sendError(HttpServletResponse.SC_FORBIDDEN);   
        return SecurityUtils.getSubject().isAuthenticated();
    }

}
