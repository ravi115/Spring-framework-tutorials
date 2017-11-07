package com.springdemo.di.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springdemo.di.os.OperatingSystem;

/**
 * This is the Example of constructor injection.
 * @author raviranjan
 *
 */
@Component
public class RedMi implements Mobile {

	private OperatingSystem os;
	
	/*
	 * constructor dependency injection.
	 * we use @AutoWired annotation to insert dependency injection.
	 * 1. @AutoWired || @AutoWired(required=true)
	 * 2. if the target dependent packages contain more than one class, then use 
	 * @Qualifier("class-name-bean-id") to invoke the required class.  
	 */
	@Autowired
	public RedMi(@Qualifier("androidPhone") OperatingSystem os) {
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
