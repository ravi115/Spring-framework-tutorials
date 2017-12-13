package com.spring.aop.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.configure.AOPDecalarationPointCutConfig;
import com.spring.aop.dao.ServicesDAO;
import com.spring.aop.pojo.Services;

public class MainDemoPointCutComplexApp {

	public static void main(String[] args) {
		
		
		//read the spring java config class.
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AOPDecalarationPointCutConfig.class);
		
		//get the bean from spring container
		ServicesDAO theServices = context.getBean("servicesDAO", ServicesDAO.class);
		
		
		//create a service
		Services service = new Services();
		
		//call the business method
		theServices.addAccount(service, true);
		theServices.doWork();
		
		//call the getter and setter
		theServices.setName("ravi");
		theServices.setServiceCode("402dg");
		
		theServices.getName();
		theServices.getServiceCode();
		

		//close the context
		
	}

}
