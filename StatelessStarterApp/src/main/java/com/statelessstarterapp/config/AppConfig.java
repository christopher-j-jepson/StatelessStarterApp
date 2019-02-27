package com.statelessstarterapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * The viewResolver class is traditionally found within a servlet.xml file.
 */
@Configuration 
@ComponentScan({"com.statelessstarterapp.core.component", "com.statelessstarterapp.core.controller"}) 
@EnableWebMvc   
public class AppConfig {  

	@Bean
	public UrlBasedViewResolver vewResolver() {

		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		String prefix = "/WEB-INF/jsp/";
		String suffix = ".jsp";
		
		viewResolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		viewResolver.setPrefix(prefix);
		viewResolver.setSuffix(suffix);
		
		return viewResolver;
		
	}
	
} 