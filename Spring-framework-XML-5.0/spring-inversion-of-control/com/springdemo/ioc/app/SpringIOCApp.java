package com.springdemo.ioc.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.ioc.coach.Coach;

/**
 * This class will illustrate Inversion-of-control concept.
 * @author raviranjan
 *
 */
public class SpringIOCApp {

	public static void main(String[] args) {
		
		/*
		 * read context file.
		 * loading of context file into spring container. 
		 * load context file from class path
		 * 
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("inversion-of-control.xml");
		
		/*
		 *create bean object. 
		 * 
		 */
		Coach theCoach = context.getBean("MyCoach", Coach.class);
		
		/*
		 * perform bean method 
		 */
		System.out.println(theCoach.getInstruction());
		
		/*
		 *shutdown the bean 
		 */
		context.close();
		
	}

}
