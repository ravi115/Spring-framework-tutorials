package com.springdemo.di.properties;

import org.springframework.beans.factory.annotation.Value;

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
