package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.aop.pojo.Employees;

@Aspect
@Component
@Order(5)
public class MyAPIAnalyticsJointsAspects {

	@Before("com.spring.aop.aspect.SpringAopExpressionJointAspects.forDaoPackageNogetterandSetter()")
	public void performaAPIAnalysis(JoinPoint theJointPoint) {
		System.out.println("\n==>@Performing API Analysis.......");
		
		MethodSignature methodSign = (MethodSignature) theJointPoint.getSignature(); 
		System.out.println("method = : " + methodSign);
		
		//display the method args
		
		Object[] args = theJointPoint.getArgs();
		
		//loop through all args
		for(Object tempArgs : args) {
			
			System.out.println(tempArgs);
			
			if(tempArgs instanceof Employees) {
				//downcast to Employees
				
				Employees theEmployee = (Employees) tempArgs;
				System.out.println("Employee name " + theEmployee.getName());
				System.out.println("Employee Email " + theEmployee.getEmail());
			}
		}
	}
	
}
