/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author g.gonzalez10
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.uniandes.csw.mpcellphone.providers.CreatedFilter.class);
        resources.add(co.edu.uniandes.csw.mpcellphone.providers.EJBExceptionMapper.class);
        resources.add(co.edu.uniandes.csw.mpcellphone.services.CartItemService.class);
        resources.add(co.edu.uniandes.csw.mpcellphone.services.CellPhoneService.class);
        resources.add(co.edu.uniandes.csw.mpcellphone.services.ClientService.class);
        resources.add(co.edu.uniandes.csw.mpcellphone.services.OrderService.class);
        resources.add(co.edu.uniandes.csw.mpcellphone.services.PaymentMethodService.class);
        resources.add(co.edu.uniandes.csw.mpcellphone.services.ProductService.class);
        resources.add(co.edu.uniandes.csw.mpcellphone.services.ProviderService.class);
        resources.add(co.edu.uniandes.csw.mpcellphone.services.ShipService.class);
        resources.add(co.edu.uniandes.csw.mpcellphone.services.TaxService.class);
        resources.add(co.edu.uniandes.csw.mpcellphone.services.TransactionService.class);
        resources.add(co.edu.uniandes.csw.mpcellphone.services.UserService.class);
        resources.add(com.sun.jersey.moxy.MoxyContextResolver.class);
        resources.add(com.sun.jersey.moxy.MoxyListMessageBodyWorker.class);
        resources.add(com.sun.jersey.moxy.MoxyMessageBodyWorker.class);
        resources.add(org.eclipse.persistence.jpa.rs.exceptions.JPARSExceptionMapper.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.EntityResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.MetadataResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.PersistenceResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.PersistenceUnitResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.QueryResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.SingleResultQueryResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.unversioned.EntityResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.unversioned.PersistenceResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.unversioned.PersistenceUnitResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.unversioned.QueryResource.class);
        resources.add(org.eclipse.persistence.jpa.rs.resources.unversioned.SingleResultQueryResource.class);
        resources.add(org.glassfish.admin.rest.provider.ActionReportResultHtmlProvider.class);
        resources.add(org.glassfish.admin.rest.provider.ActionReportResultJsonProvider.class);
        resources.add(org.glassfish.admin.rest.provider.ActionReportResultXmlProvider.class);
        resources.add(org.glassfish.admin.rest.provider.BaseProvider.class);
        resources.add(org.glassfish.admin.rest.provider.FormWriter.class);
        resources.add(org.glassfish.admin.rest.provider.GetResultListHtmlProvider.class);
        resources.add(org.glassfish.admin.rest.provider.GetResultListJsonProvider.class);
        resources.add(org.glassfish.admin.rest.provider.GetResultListXmlProvider.class);
        resources.add(org.glassfish.admin.rest.provider.OptionsResultJsonProvider.class);
        resources.add(org.glassfish.admin.rest.provider.OptionsResultXmlProvider.class);
        resources.add(org.glassfish.admin.rest.readers.FormReader.class);
        resources.add(org.glassfish.admin.rest.readers.JsonHashMapProvider.class);
        resources.add(org.glassfish.admin.rest.readers.JsonParameterMapProvider.class);
        resources.add(org.glassfish.admin.rest.readers.JsonPropertyListReader.class);
        resources.add(org.glassfish.admin.rest.readers.ParameterMapFormReader.class);
        resources.add(org.glassfish.admin.rest.readers.XmlHashMapProvider.class);
        resources.add(org.glassfish.admin.rest.readers.XmlPropertyListReader.class);
        resources.add(org.glassfish.admin.rest.resources.GeneratorResource.class);
        resources.add(org.glassfish.admin.rest.resources.MonitoringResource.class);
        resources.add(org.glassfish.admin.rest.resources.ReloadResource.class);
        resources.add(org.glassfish.admin.rest.resources.SessionsResource.class);
        resources.add(org.glassfish.admin.rest.resources.StaticResource.class);
        resources.add(org.glassfish.admin.rest.resources.StatusGenerator.class);
        resources.add(org.glassfish.admin.rest.resources.custom.ManagementProxyResource.class);
    }
    
}
