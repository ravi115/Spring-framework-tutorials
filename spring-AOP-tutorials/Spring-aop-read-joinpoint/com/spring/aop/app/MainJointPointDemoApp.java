package com.spring.aop.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.configure.AOPPointJointConfiguration;
import com.spring.aop.dao.EmployeesDAO;
import com.spring.aop.pojo.Employees;


public class MainJointPointDemoApp {

	public static void main(String[] args) {
		
		//load the spring container with configuration from java configure class
		ApplicationContext context =
				new AnnotationConfigApplicationContext(AOPPointJointConfiguration.class);
		
		//get the bean from spring container
		EmployeesDAO theEmployee = context.getBean("employeesDAO", EmployeesDAO.class);

		//create Employees Object with populate some Employee data
		Employees emp = new Employees();
		emp.setName("ravi ranjan");
		emp.setEmail("ravi115ranjan@gmail.com");
		
		
		//execute the business method of EmployeeDAO class
		theEmployee.addEmployee(emp, true);
		theEmployee.updateEmployee(false);
		theEmployee.getLevel();
		theEmployee.setLevel("level-1");
		theEmployee.getEmployeeCode();
		theEmployee.setEmployeeCode("123ER");
	}

}
