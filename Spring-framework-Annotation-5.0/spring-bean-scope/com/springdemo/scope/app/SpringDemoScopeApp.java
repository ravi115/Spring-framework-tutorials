package com.springdemo.scope.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.scope.cycle.Cycle;

public class SpringDemoScopeApp {

	public static void main(String[] args) {
		
		/*
		 * load application context file into spring container 
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		/*
		 * create the bean object to illustrate singleton scope or default scope.
		 * in this approach only one object of bean is being created by Spring container.
		 */
		Cycle objC1 = context.getBean("avonCycle", Cycle.class);
		Cycle objC2 = context.getBean("avonCycle", Cycle.class);
			
		/*
		 * perform the operation on bean method  
		 * 
		 */
		boolean result = objC1 == objC2;
		System.out.println("Both the objects are same (true/flase)? : " + result);
		System.out.println("Address -1 " + objC1);
		System.out.println("Address -2 " + objC2);
		
		System.out.println("<--===========================================-->");
		/*
		 * create the bean object to illustrate prototype scope.
		 * in this approach for every request, every time a new object will be created. 
		 */
		Cycle objH1 = context.getBean("heroCycle", Cycle.class);
		Cycle objH2 = context.getBean("heroCycle", Cycle.class);
			
		/*
		 * perform the operation on bean method  
		 * 
		 */
		boolean resultPrototype = objH1 == objH2;
		System.out.println("Both the objects are same (true/flase)? : " + resultPrototype);
		System.out.println("Address -1 " + objH1);
		System.out.println("Address -2 " + objH2);
		
		/*
		 * close the spring container
		 */
		context.close();
	}

}
