package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * This is aspect class where we will add our all logging related stuff. 
 * @author raviranjan
 *
 */
@Aspect
@Component
public class MyDemoLoggingDecalarationAspect {

	/**
	 * 
	 * Let's create the pointcut expression. 
	 */
	@Pointcut("execution(* com.spring.aop.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//use the point cut expression to define our advice.
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====> Executing @Before Aspects{advice} for method");
	}
	
	/**
	 * create a new advice 
	 */
	//re-use the point cut expression to define our new advice.
	@Before("forDaoPackage()")
	public void performAnalytics() {
		System.out.println("\n=======> performing API Analytics {new Advice} for methods");
	}
	
	/**
	 * 
	 * we can also combine the pointcut expression using logical expression.
	 * 
	 * add(&&)
	 * or (||)
	 * Not (!)
	 *  
	 *  it exactly works like `if` statement.
	 * 
	 */
	
}
