package com.spring.aop.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.configure.AOPConfigforAfterreturning;
import com.spring.aop.dao.UserDAO;
import com.spring.aop.pojo.Users;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		
		//read the spring java config class.
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AOPConfigforAfterreturning.class);
		
		//get the bean from spring container
		UserDAO theUserDAO = context.getBean("userDAO", UserDAO.class);
		
		//create a account
		Users myAccount = new Users("ravi", "software enginer");
		//call the business method
		theUserDAO.addAccount(myAccount, false);
		theUserDAO.doWork();
		
		//Let's do it again to check whether Aspectj work every time.
		System.out.println("\n Calling it one more time");
		theUserDAO.addAccount(myAccount, true);
		theUserDAO.doWork();
		
		//add the List<user>
		List<Users> MyUser = theUserDAO.findUsers();
		
		System.out.println("all the users are..........");
		System.out.println(MyUser);
		//close the context
		
	}

}
