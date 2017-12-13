package com.spring.aop.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.configure.AOPDecalarationPointCutConfig;
import com.spring.aop.dao.AccountsDAO;
import com.spring.aop.dao.MembershipsDAO;
import com.spring.aop.pojo.Accounts;

public class MainDemoPointCutApp {

	public static void main(String[] args) {
		
		
		//read the spring java config class.
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AOPDecalarationPointCutConfig.class);
		
		//get the bean from spring container
		AccountsDAO theAccount = context.getBean("accountsDAO", AccountsDAO.class);
		
		//get the member bean from spring container
		MembershipsDAO theMember = context.getBean("membershipsDAO", MembershipsDAO.class);
		
		//create a account
		Accounts myAccount = new Accounts();
		//call the business method
		theAccount.addAccount(myAccount, false);
		theAccount.doWork();
		
		//Let's do it again to check whether Aspectj work every time.
		System.out.println("\n Calling it one more time");
		theAccount.addAccount(myAccount, true);
		theAccount.doWork();
		
		//call the business method of membership method.
		System.out.println("\n<------- ** member ship method ** -------->");
		theMember.addAccount();
		theMember.addShillyMember();
		theMember.goToSleep(false);
		//close the context
		
	}

}
