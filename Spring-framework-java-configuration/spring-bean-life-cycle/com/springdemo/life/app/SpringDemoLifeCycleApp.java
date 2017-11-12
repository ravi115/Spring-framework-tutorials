package com.springdemo.life.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.life.fruits.Fruits;
import com.springdemo.xml.config.AppContextConfig;

public class SpringDemoLifeCycleApp {

	public static void main(String[] args) {
		
		/*
		 * configure the spring container form below annotated config class specified in its argument. 
		 */
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppContextConfig.class);
	
		/*
		 * create the bean object to illustrate the life cycle of bean.
		 */
		Fruits obj = context.getBean("MyOrangeFruits", Fruits.class);
		
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
