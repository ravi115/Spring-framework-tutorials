package com.springdemo.di.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.di.mobile.Mobile;
import com.springdemo.di.properties.PropertyInjection;
import com.springdemo.xml.config.MobileConfigContext;

public class SpringDemoDIApp {

	public static void main(String[] args) {
		
		/*
		 * load this config java class to spring container. 
		 */
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(MobileConfigContext.class);
	
		/*
		 * create the bean object to illustrate constructor dependency injection. 
		 */
		Mobile redMiMobile = context.getBean("MyRedMiPhone", Mobile.class);
		
		/*
		 * create bean object to illustrate setter injection. 
		 
		Mobile iPhone = context.getBean("IPhone8", Mobile.class);
		
		 * create bean object to illustrate field injection. 
		 
		Mobile winPhone = context.getBean("lumiya800Phone", Mobile.class);
		
		*/
		
		/*
		 *create bean to illustrate the Property Injection. 
		 */
		
		PropertyInjection obj = context.getBean("MyProperty", PropertyInjection.class);
		
		/*
		 * perform the operation on bean method   
		 */
		System.out.println("Mobile : " +  redMiMobile.getMobile());
		System.out.println("OS Used : " + redMiMobile.getMobileOS());
		
		System.out.println("<=========================================>");
		
		/*System.out.println("Mobile : " +  iPhone.getMobile());
		System.out.println("OS Used : " + iPhone.getMobileOS());
		
		System.out.println("<=========================================>");
		

		System.out.println("Mobile : " +  winPhone.getMobile());
		System.out.println("OS Used : " + winPhone.getMobileOS());
		
		System.out.println("<=========================================>");
		*/
		System.out.println("Email-Id : " + obj.getEmail());
		System.out.println("Home-Town : " + obj.getHomeTown());
		/*
		 * close the spring container
		 */
		context.close();
	}

}
