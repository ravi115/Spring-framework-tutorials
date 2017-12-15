package com.spring.aop.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.configure.AOPConfigforAfterFinally;
import com.spring.aop.dao.ProducreDAO;
import com.spring.aop.pojo.Producer;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		
		//read the spring java config class.
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AOPConfigforAfterFinally.class);
		
		//get the bean from spring container
		ProducreDAO theUserDAO = context.getBean("producreDAO", ProducreDAO.class);
		
		//create a account
		Producer myAccount = new Producer("ravi", "software enginer");
		//call the business method
		theUserDAO.addAccount(myAccount, false);
		theUserDAO.doWork();
		
		//Let's do it again to check whether Aspectj work every time.
		System.out.println("\n Calling it one more time");
		theUserDAO.addAccount(myAccount, true);
		theUserDAO.doWork();
		
		List<Producer> MyUser = null;
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
