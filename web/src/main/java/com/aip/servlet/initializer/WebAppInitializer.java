package com.aip.servlet.initializer;

import com.aip.service.configuration.ApplicationConfigurationService;
import com.aip.servlet.config.SecurityConfig;
import com.aip.servlet.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String SERVLET_MAPPING = "/";

    @Override
    protected Class<?>[] getRootConfigClasses() { return new Class[]{SecurityConfig.class, ApplicationConfigurationService.class}; }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class[]{WebConfiguration.class};
//    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{SERVLET_MAPPING};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }

}
