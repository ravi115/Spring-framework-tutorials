package com.spring.aop.dao;

import org.springframework.stereotype.Component;

import com.spring.aop.pojo.Employees;

@Component
public class EmployeesDAO {

	private String level;
	private String employeeCode;
	
	
	public void addEmployee(Employees emp, boolean bIsLazy) {
		
		System.out.println("Employees are too lazy.............");
	}
	
	public boolean updateEmployee(boolean bIsupdated) {
		
		boolean bIsUpdated = false;
		
		System.out.println("employees are updated");
		
		return bIsUpdated;
	}

	public String getLevel() {
		System.out.println("called getter method - getLevel()");
		return level;
	}

	public void setLevel(String level) {
		System.out.println("called the level setter method - "  + level);
		this.level = level;
	}

	public String getEmployeeCode() {
		System.out.println("called getter method -  getEmployeeCode()" );
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		System.out.println("called the employee code setter method - " + employeeCode);
		this.employeeCode = employeeCode;
	}
	
}
