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
public class MyDemoLoggingPointCutAspect {

	/**
	 * 
	 * Let's create the point cut expression. 
	 */
	@Pointcut("execution(* com.spring.aop.dao.*.*(..))")
	private void forDaoPackage() {}
	
	/**
	 * 
	 * we can also combine the point cut expression using logical expression.
	 * 
	 * add(&&)
	 * or (||)
	 * Not (!)
	 *  
	 *  it exactly works like `if` statement.
	 * 
	 */
	
	//create point cut for getter method
	@Pointcut("execution(* com.spring.aop.dao.*.get(..))")
	private void gettter() {}
	
	//create point cut for setter method
	@Pointcut("execution(* com.spring.aop.dao.*.*set(..))")
	private void setter() {}

	//create point cut : include package... exclude getter & setter
	@Pointcut("forDaoPackage() && !(gettter() || setter())")
	private void noGetterAndSetterforDAO() {}
	
	
	//use the point cut expression to define our advice.
	@Before("noGetterAndSetterforDAO()")
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
	
}
