package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * This is aspect class where we will add our all logging related stuff. 
 * @author raviranjan
 *
 */
@Aspect
@Component
public class MyDemoLoggingAspect {

	/** 
	 * Let's start with an @Before advice. 
	 * The below point cut expression matches with any method with addAccount in any class.
	 */
	//@Before("execution(public void addAccount())")
	
	
	/** 
	 * point cut expression to only call only AccountDAO
	 * 
	 */
	//@Before("execution(public void com.spring.aop.dao.AccountDAO.addAccount())")
	
	/**
	 * point cut expression to match any method starts with add in any classes. 
	 * Now {*} is known as wild card entry matches with any character.
	 * access modifier is an optional.
	 * to generalize return type use {*} wild card instread. 
	 */
	//@Before("execution(* add*())")
	
	/**
	 * point cut expression to accept any number of argument by a method.  
	 * 
	 * use (..) to accept zero or any number of argument.
	 * 
	 * This will be any add method available in any package.
	 * 
	 */
	//@Before("execution(* add*(..))")
	
	/**
	 * point cut expression to matches with any class with any method inside some specified package.  
	 * 
	 * use { myPackage.*.*(..)} -- > 1st * for class then 2nd * for method name then (..) for any 
	 * argument accepted by any method. 
	 * 
	 */
	//@Before("execution(* com.spring.aop.*.*(..))")
	
	@Before("execution(* com.spring.aop.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====> Executing @Before Aspects{advice} for method");
	}
}
