package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SpringAopExpressionAspects {

	//create a pointcut expression for all method available in EmployeeDAO
	@Pointcut("execution(* com.spring.aop.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//create a pointcut expression for all setter method
	@Pointcut("execution(* com.spring.aop.dao.*.set*(..))")
	public void setter() {}
	
	//create a pointcut expression for all gettter method
	@Pointcut("execution(* com.spring.aop.dao.*.get*(..))")
	public void gettter() {}
	
	//point cut expression which excludes all getter and setter
	@Pointcut("forDaoPackage() && !(setter() || gettter())")
	public void forDaoPackageNogetterandSetter() {}
	
}
