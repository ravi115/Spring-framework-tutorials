package com.springdemo.ioc.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.ioc.mobile.Mobile;

public class SpringDemoIOCApp {

	public static void main(String[] args) {
		
		/*
		 * load application context file into spring container 
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		/*
		 * create the bean object when id is specified in @component annotation.
		 */
		Mobile appleMob = context.getBean("MyApplePhone", Mobile.class);
		
		/*
		 * create the bean object when id is not specified in @component annotation.
		 * so spring container uses the class name as bean id with first letter in lower case.
		 */
		Mobile androidMob = context.getBean("androidPhone", Mobile.class);
		
		/*
		 * create the bean object when id is not specified in @component annotation.
		 * so spring container uses exact class name as bean id since the class name is having first letter
		 * in upper case after that second letter is in also upper case.
		 */
		Mobile windowMob = context.getBean("WINdowsPhone", Mobile.class);
		
		/*
		 * perform the operation on bean method  
		 * 
		 */
		System.out.println(appleMob.getMyMobile());
		System.out.println(androidMob.getMyMobile());
		System.out.println(windowMob.getMyMobile());
		
		/*
		 * close the spring container
		 */
		context.close();
	}

}
