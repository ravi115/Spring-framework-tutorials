package com.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * This is aspect class where we will add our all logging related stuff. 
 * @author raviranjan
 *
 */
@Aspect
@Component
public class AroundLogging {

	//around advice
	@Around("execution(* com.spring.aop.service.*.getFortune(..))")
	public Object aroundAdviceFortune(ProceedingJoinPoint theJoinPoint) throws Throwable {

		//print out the method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>Excecuting @around on method : " + method);

		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		//now let's execute the method
		Object result = theJoinPoint.proceed();
		
		//get end timestamp 
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		long duration = end - begin;
		System.out.println("Time duration : " + duration/1000.0 + "seconds");
		
		return result;
	}

}
