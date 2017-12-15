package com.spring.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.spring.aop.pojo.Consumers;

/**
 * This is aspect class where we will add our all logging related stuff. 
 * @author raviranjan
 *
 */
@Aspect
@Component
public class AfterThrowingLogging {

	//after throwing
	@AfterThrowing(
			pointcut="execution(* com.spring.aop.dao.ConsumersDAO.findUsers(..))",
			throwing="theExc"
			)
	public void afterThrowing(JoinPoint thejoinPoint, Throwable theExc) {
		
		//print out the method we are advising on
		String method = thejoinPoint.getSignature().toShortString();
		System.out.println("\n====>Excecuting @afterReturining on method : " + method);

		//log the error message
		System.out.println("==>eXception is :" + theExc);
	}
	
	
	//after returning
	@AfterReturning(
			pointcut="execution(* com.spring.aop.dao.ConsumersDAO.findUsers(..))",
			returning="result"
			)
	public void afterReturningFindUsers(JoinPoint theJoinPoint, List<Consumers> result) {
		
		//printout which method we are advising  on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>Excecuting @afterReturining on method : " + method);
		
		System.out.println("result is :\n" + result);
		
		//let's post process the data; modify the result
		convertsAccountNamesToUpperCase(result);
		
		System.out.println("upper case version of name");
		
		System.out.println("result is :\n" + result);
	}
	
	private void convertsAccountNamesToUpperCase(List<Consumers> result) {
		
		//loop through all the accounts
		for(Consumers user : result) {
			
			//get the upper case version of name
			String name = user.getName().toUpperCase();
			
			//update the name on users
			user.setName(name);
		}
		
	}

	
	
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
