package com.springdemo.life.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.life.fruits.Fruits;

public class SpringDemoLifeCycleApp {

	public static void main(String[] args) {
		
		/*
		 * load application context file into spring container 
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		/*
		 * create the bean object to illustrate the life cycle of bean.
		 */
		Fruits obj = context.getBean("orangeFruits", Fruits.class);
		
		/*
		 * perform the operation on bean method  
		 * 
		 */
		System.out.println(obj.getFruits());
		
		/*
		 * close the spring container
		 */
		context.close();
	}

}
