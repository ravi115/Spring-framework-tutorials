package com.springdemo.di.mobile;

import com.springdemo.di.os.OperatingSystem;

/**
 * This is the Example of constructor injection.
 * @author raviranjan
 *
 */
public class RedMi implements Mobile {

	private OperatingSystem os;
	
	public RedMi(OperatingSystem os) {
		this.os = os;
	}
	
	@Override
	public String getMobile() {
		return "This is an RedMi Note 4 phone";
	}
	/*
	 * use of dependency injection is here. 
	 */
	@Override
	public String getMobileOS() {
		return os.getOS();
	}
}
