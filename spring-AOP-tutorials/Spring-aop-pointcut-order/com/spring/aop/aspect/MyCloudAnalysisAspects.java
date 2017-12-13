package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudAnalysisAspects {

	@Before("com.spring.aop.aspect.SpringAopExpressionAspects.forDaoPackage()")
	public void performaCloudAnalysis() {
		System.out.println("\n==>@Performing Cloud Analysis.......");
	}
}
