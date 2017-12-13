package com.spring.aop.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.configure.AOPPointCutOrderConfiguration;
import com.spring.aop.dao.EmployeeDAO;
import com.spring.aop.pojo.Employee;


public class MainPointCutOrderDemoApp {

	public static void main(String[] args) {
		
		//load the spring container with configuration from java configure class
		ApplicationContext context =
				new AnnotationConfigApplicationContext(AOPPointCutOrderConfiguration.class);
		
		//get the bean from spring container
		EmployeeDAO theEmployee = context.getBean("employeeDAO", EmployeeDAO.class);

		//execute the business method of EmployeeDAO class
		theEmployee.addEmployee(new Employee(), true);
		theEmployee.updateEmployee(false);
		theEmployee.getLevel();
		theEmployee.setLevel("level-1");
		theEmployee.getEmployeeCode();
		theEmployee.setEmployeeCode("123ER");
	}

}
