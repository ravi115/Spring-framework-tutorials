package com.springdemo.di.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo.di.car.HondaCar;
import com.springdemo.di.car.MarutiCar;
import com.springdemo.di.factory.CarFactory;

/**
 * This class will illustrate the Dependency injection concept using XML
 * configuration based setup.
 * @author raviranjan
 *
 */
public class SpringDependencyInjectionApp {

	public static void main(String[] args) {
		/*
		 * read context file.
		 * loading of context file into spring container. 
		 * load context file from class path
		 * 
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dependency-injection.xml");
		/*
		 *perform constructor dependency injection 
		 */
		constructorInjection(context);

		/*
		 *perform setter dependency injection. 
		 * 
		 */
		setterInjection(context);
		/*
		 *perform variable injection 
		 * 
		 */
		fieldInjection(context);
		/*
		 *perform properties file injection 
		 * 
		 */
		propertiesFileInjection(context);
		/*
		 *shutdown the bean 
		 */
		context.close();

	}

	private static void constructorInjection(final ClassPathXmlApplicationContext context) {
		
		System.out.println("<--Constructor injection-->");
		/*
		 *create bean object. 
		 * This bean is responsible to perform constructor-injection.
		 */
		CarFactory theCar = context.getBean("MyBMW", CarFactory.class);

		/*
		 * perform bean method 
		 */
		System.out.println(theCar.getCar());
		/*
		 * perform the dependent method. 
		 */
		System.out.println(theCar.getEngine());

	}
	private static void setterInjection(final ClassPathXmlApplicationContext context) {

		System.out.println("<--setter injection-->");
		/*
		 *create bean object. 
		 * This bean is responsible to perform constructor-injection.
		 */
		CarFactory theCar = context.getBean("MyAudi", CarFactory.class);

		/*
		 * perform bean method 
		 */
		System.out.println(theCar.getCar());
		/*
		 * perform the dependent method. 
		 */
		System.out.println(theCar.getEngine());

	}

	private static void fieldInjection(final ClassPathXmlApplicationContext context) {

		System.out.println("<--Field/literals injection-->");
		/*
		 *create bean object. 
		 * This bean is responsible to perform constructor-injection.
		 */
		CarFactory theCar = context.getBean("MyMaruti", CarFactory.class);

		/*
		 * perform bean method 
		 */
		System.out.println(theCar.getCar());
		/*
		 * perform the dependent method. 
		 */
		System.out.println(theCar.getEngine());
		
		/*
		 * read field injection. 
		 */
		MarutiCar maruti = (MarutiCar) theCar;
		System.out.println("Maruti-->name : " + maruti.getName());
		System.out.println("Maruti-->Email :" + maruti.getEmail());

	}
	private static void propertiesFileInjection(final ClassPathXmlApplicationContext context) {

		System.out.println("<--properties file injection-->");
		/*
		 *create bean object. 
		 * This bean is responsible to perform constructor-injection.
		 */
		CarFactory theCar = context.getBean("MyHonda", CarFactory.class);

		/*
		 * perform bean method 
		 */
		System.out.println(theCar.getCar());
		/*
		 * perform the dependent method. 
		 */
		System.out.println(theCar.getEngine());
		
		/*
		 * To print method of implementing class, we have to use down casting mechanism. 
		 * 
		 */
		HondaCar honda = (HondaCar) theCar;
		System.out.println("owner name--> " + honda.getOwnerName());
		System.out.println("owner phone--> " + honda.getOwnerMobile());
	}

}
