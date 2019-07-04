package com.app.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//  // Load database and spring security configuration
//  @Override
//  protected Class<?>[] getRootConfigClasses() {
//    return new Class[] { AppConfig.class, WebSecurityConfig.class };
//  }
//
//  // Load spring web configuration
//  @Override
//  protected Class<?>[] getServletConfigClasses() {
//    return new Class[] { WebConfig.class };
//  }
//
//  @Override
//  protected String[] getServletMappings() {
//    return new String[] { "/" };
//  }
//
//}

public class MvcWebApplicationInitializer implements WebApplicationInitializer {

	 @Override
	 public void onStartup(ServletContext container) {
	  // Create the 'root' Spring application context
	  AnnotationConfigWebApplicationContext rootContext =
	                       new AnnotationConfigWebApplicationContext();
	  rootContext.register(AppConfig.class, WebSecurityConfig.class);

	  // Manage the lifecycle of the root application context
	  container.addListener(new ContextLoaderListener(rootContext));

	  // Create the dispatcher servlet's Spring application context
	  AnnotationConfigWebApplicationContext dispatcherContext =
	                     new AnnotationConfigWebApplicationContext();
	  dispatcherContext.register(WebConfig.class);

	  // Register and map the dispatcher servlet
	  ServletRegistration.Dynamic dispatcher =
	    container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
	    dispatcher.setLoadOnStartup(1);
	    dispatcher.addMapping("/");
	  }
	}