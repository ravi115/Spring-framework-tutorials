package com.jersey.spring.server.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Order(1)
public class SpringInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		servletContext.setInitParameter("contextConfigLocation", "noop");
		
		AnnotationConfigWebApplicationContext  objContext
			= new AnnotationConfigWebApplicationContext ();
		objContext.register(SpringConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(objContext));
		servletContext.addListener(new RequestContextListener());
		
	}

}
