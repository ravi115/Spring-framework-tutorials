package com.springdemo.scope.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.scope.theater.Theater;

public class SpringDemoBeanScopeApp {

	public static void main(String[] args) {
		
		/*
		 *load context file into spring container. 
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
		
		/*
		 * singleton illustration 
		 */
		singletonScope(context);
		/*
		 * prototype illustration 
		 */
		prototypeScope(context);
	
		/*
		 *close the context 
		 */
		context.close();
	}
	
	private static void singletonScope(ClassPathXmlApplicationContext context) {
		System.out.println("<---- singleton scope--->");

		/*
		 * create the bean object 
		 */
		Theater cinema1 = context.getBean("MySingletonScope", Theater.class);
		Theater cinema2 = context.getBean("MySingletonScope", Theater.class);
		
		/*
		 * in case of singleton both cinema1 and cinema2 will point to same reference.
		 */
		boolean bIs_singletonBean = cinema1 == cinema2;
		/*
		 * test both bean object. 
		 */
		System.out.println("Both the bean are same : " + bIs_singletonBean);
		System.out.println("The refernce pointed by cinema1 -- > " + cinema1);
		System.out.println("The refernce pointed by cinema2 -- > " + cinema2);
		
	}
	
	
	private static void prototypeScope(ClassPathXmlApplicationContext context) {
		System.out.println("<---- prototype scope--->");

		/*
		 * create the bean object 
		 */
		Theater cinema1 = context.getBean("MyPrototypeScope", Theater.class);
		Theater cinema2 = context.getBean("MyPrototypeScope", Theater.class);
		
		/*
		 * in case of singleton both cinema1 and cinema2 will point to same reference.
		 */
		boolean bIs_prototypeBean = cinema1 == cinema2;
		/*
		 * test both bean object. 
		 */
		System.out.println("Both the bean are same : " + bIs_prototypeBean);
		System.out.println("The refernce pointed by cinema1 -- > " + cinema1);
		System.out.println("The refernce pointed by cinema2 -- > " + cinema2);
		
	}
}
