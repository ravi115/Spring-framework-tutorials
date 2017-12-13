package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(5)
public class MyAPIAnalyticsAspects {

	@Before("com.spring.aop.aspect.SpringAopExpressionAspects.forDaoPackageNogetterandSetter()")
	public void performaAPIAnalysis() {
		System.out.println("\n==>@Performing API Analysis.......");
	}
	
}
