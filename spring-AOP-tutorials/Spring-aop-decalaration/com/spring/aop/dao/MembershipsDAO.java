package com.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipsDAO {

	/*
	 * This method will get matched with pointcut expression in Aspectj 
	 */
	public void addAccount() {
	
		System.out.println(getClass() + " : adding a member..");
	}
	
	public boolean addShillyMember() {
		System.out.println(getClass() + " : adding a shilly member..");
		return true;
	}
	
	public boolean goToSleep(boolean shouldI) {
		
		System.out.println("Should I sleep ? " + shouldI);
		return shouldI;
	}
}
