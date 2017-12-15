package com.spring.aop.app;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.configure.AOPConfigforAroundHandleException;
import com.spring.aop.service.TrafficFortunesService;

public class ArounWithLoggerdDemoApp {

	private static Logger MyLogger = Logger.getLogger(ArounWithLoggerdDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		
		//read the spring java config class.
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AOPConfigforAroundHandleException.class);
		
		//get the bean from spring container
		TrafficFortunesService trafficFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortunesService.class);
		
		MyLogger.info("\nMain program demo APP :" + "Around APP");
		MyLogger.info("Calling fortune");
		
		String data = trafficFortuneService.getFortune();
		
		MyLogger.info("\nMy fortune is : " + data);
		MyLogger.info("\nFinished");
		//close the context
		
	}

}
