package com.springdemo.bean.life.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.bean.life.coach.Coach;

public class SpringBeanLifeCycleDemo {

	public static void main(String[] args) {
		/*
		 *load the context file into spring container. 
		 * 
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life-cycle.xml");
		
		/*
		 * create coach type bean. 
		 */
		Coach theCoach = context.getBean("MyCoach", Coach.class);
		
		/*
		 * call bean class.
		 * so first bean init method will be called.
		 * then other method will be called.
		 * at last destroy method will be called. 
		 */
		System.out.println(theCoach.getWorkDone());
		
		/*
		 * close the context object. 
		 */
		context.close();

	}

}
