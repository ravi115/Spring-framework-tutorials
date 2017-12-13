package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudAnalysisJointAspects {

	@Before("com.spring.aop.aspect.SpringAopExpressionJointAspects.forDaoPackage()")
	public void performaCloudAnalysis() {
		System.out.println("\n==>@Performing Cloud Analysis.......");
	}
}
