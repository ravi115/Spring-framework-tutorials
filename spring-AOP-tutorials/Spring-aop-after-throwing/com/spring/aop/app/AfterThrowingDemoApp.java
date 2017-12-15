package com.spring.aop.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.configure.AOPConfigforAfterThrowing;
import com.spring.aop.dao.ConsumersDAO;
import com.spring.aop.pojo.Consumers;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		
		//read the spring java config class.
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AOPConfigforAfterThrowing.class);
		
		//get the bean from spring container
		ConsumersDAO theUserDAO = context.getBean("consumersDAO", ConsumersDAO.class);
		
		//create a account
		Consumers myAccount = new Consumers("ravi", "software enginer");
		//call the business method
		theUserDAO.addAccount(myAccount, false);
		theUserDAO.doWork();
		
		//Let's do it again to check whether Aspectj work every time.
		System.out.println("\n Calling it one more time");
		theUserDAO.addAccount(myAccount, true);
		theUserDAO.doWork();
		
		List<Consumers> MyUser = null;
		try {
			//use a boolean to throw exception
			boolean tripWire = true;
			MyUser = theUserDAO.findUsers(tripWire);
		
		}catch(Exception ex) {
			System.out.println("caught exception" + ex +"main program thrown exception");
		}
		//add the List<user>
		
		System.out.println("all the users are..........");
		System.out.println(MyUser);
		//close the context
		
	}

}
