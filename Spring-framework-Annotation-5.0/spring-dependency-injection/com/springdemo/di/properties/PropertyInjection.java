package com.springdemo.di.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This class shows properties file injection.
 * The properties file injection works when spring container loads the property file
 * from specified location in application-context.xml file.
 * invoke the setter method to initialize the field of class with values specified in the properties file.
 * 
 * @author raviranjan
 */
@Component
public class PropertyInjection {
	
	/*
	 * must use @value annotation to read the properties field from properties file. 
	 */
	@Value("${email}")
	private String email;
	
	@Value("${hometown}")
	private String homeTown;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	
	
}
