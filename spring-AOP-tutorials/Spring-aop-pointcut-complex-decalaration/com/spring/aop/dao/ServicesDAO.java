package com.spring.aop.dao;

import org.springframework.stereotype.Component;

import com.spring.aop.pojo.Services;

@Component
public class ServicesDAO {

	private String name;
	private String serviceCode;
	
	public void addAccount(Services theService, boolean vipPerson) {
		System.out.println(getClass() + " : " + "My Service Work : " + " Perform a service");
	}
	
	
	public void doWork() {
		System.out.println(getClass() + " : doing my serivces...." );
	}


	public String getName() {
		
		System.out.println(getClass() + " : gettter() - getName");
		return name;
	}


	public void setName(String name) {
		
		System.out.println(getClass() +  " : setter() - setName"  + name);
		this.name = name;
	}


	public String getServiceCode() {
		
		System.out.println(getClass() + " : gettter() - getServiceCode");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		
		System.out.println(getClass() +  " : setter() - setServiceCode " + serviceCode);
		this.serviceCode = serviceCode;
	}
	
	
	
}
