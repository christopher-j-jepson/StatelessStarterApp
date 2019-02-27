package com.statelessstarterapp.config;

import javax.servlet.ServletContext;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRegistration.Dynamic;  
import org.springframework.web.WebApplicationInitializer;  
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;  
import org.springframework.web.servlet.DispatcherServlet;  

/**
 * The WebAppInitializer class is the substitute to web.xml file.
 */
public class WebAppInitializer implements WebApplicationInitializer {
	
	/**
	 * The onStartup method is traditionally found within a web.xml file.
	 */
	public void onStartup(ServletContext servletContext) throws ServletException {  
		
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
        ctx.register(AppConfig.class);  
        ctx.setServletContext(servletContext);    
        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
        dynamic.addMapping("/");  
        dynamic.setLoadOnStartup(1); 
        
   }  
	
} 
