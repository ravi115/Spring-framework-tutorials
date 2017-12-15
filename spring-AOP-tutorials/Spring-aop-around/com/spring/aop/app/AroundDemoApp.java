package com.spring.aop.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.configure.AOPConfigforAround;
import com.spring.aop.service.TrafficFortunesService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		
		//read the spring java config class.
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AOPConfigforAround.class);
		
		//get the bean from spring container
		TrafficFortunesService trafficFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortunesService.class);
		
		System.out.println("\nMain program demo APP :" + "Around APP");
		System.out.println("Calling fortune");
		
		String data = trafficFortuneService.getFortune();
		
		System.out.println("\nMy fortune is : " + data);
		System.out.println("\nFinished");
		//close the context
		
	}

}
