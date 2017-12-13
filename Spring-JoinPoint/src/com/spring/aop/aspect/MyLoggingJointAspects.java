package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-5)
public class MyLoggingJointAspects {

	
	@Before("com.spring.aop.aspect.SpringAopExpressionJointAspects.gettter()")
	public void beforeEmployeeDAO() { 
		System.out.println("\n===> Executing @Before Aspects{advice} for method");
	}
	
}
