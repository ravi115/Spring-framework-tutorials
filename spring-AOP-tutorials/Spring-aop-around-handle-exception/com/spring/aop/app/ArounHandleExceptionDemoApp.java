package com.spring.aop.app;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.configure.AOPConfigforAroundHandleException;
import com.spring.aop.service.TrafficFortunessService;

public class ArounHandleExceptionDemoApp {

	private static Logger MyLogger = Logger.getLogger(ArounHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		
		//read the spring java config class.
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AOPConfigforAroundHandleException.class);
		
		//get the bean from spring container
		TrafficFortunessService trafficFortuneService = 
				context.getBean("trafficFortunessService", TrafficFortunessService.class);
		
		MyLogger.info("\nMain program demo APP :" + "Around APP");
		MyLogger.info("Calling fortune");
		
		//set the exception
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		
		MyLogger.info("\nMy fortune is : " + data);
		MyLogger.info("\nFinished");
		//close the context
		
	}

}
