package com.spring.web.project.apect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * This is Logging aspects.
 * 
 * @author raviranjan
 *
 */
@Aspect
@Component
public class CRMLoggingAspects {

	
	//setup Logger
	private Logger MyLogger  = Logger.getLogger(getClass().getName());
	
	//setup pointcut declaration
	
	/**
	 * for controller package. 
	 */
	@Pointcut("execution(* com.spring.web.project.controller.*.*(..))")
	private void forControllerPackage() {}
	
	/**
	 * for service package. 
	 */
	@Pointcut("execution(* com.spring.web.project.service.*.*(..))")
	private void forServicePackage() {}
	
	/**
	 * for dao package. 
	 */
	@Pointcut("execution(* com.spring.web.project.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//apply pointcut declaration rule to give some meaning flow of aspects for this projects.
	
	/**
	 * This pointcut expression tells that the aspects can be applied on 
	 * controller,
	 * Service,
	 * DAO 
	 * 
	 */
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	//add @Before Advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display the method, we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		MyLogger.info(" = = = = >> in @Before: calling mathod : " + theMethod);
		
		/**display the method to the argument*/
		
		//get the argumants
		Object[] args = theJoinPoint.getArgs();
		
		//loop through the argument and display the argument
		for(Object tempArgs : args) {
			MyLogger.info(" = = =>> @Argumants : " + tempArgs);
		}
	}
	
	//add @AfterReturning advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		//display the method, we are returning
		String theMethod = theJoinPoint.getSignature().toShortString();
		MyLogger.info(" = = = = >> in @AfterReturining: Returning mathod : " + theMethod);
		
		//display data returned
		MyLogger.info("= = = >> Result : " + theResult);
	}
}
