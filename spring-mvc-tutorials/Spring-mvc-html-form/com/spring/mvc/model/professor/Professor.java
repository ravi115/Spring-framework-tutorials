package com.spring.mvc.model.professor;

import java.util.LinkedHashMap;

public class Professor {

	private String firstName;
	private String lastName;
	
	private String gender;
	private LinkedHashMap<String, String> genderOptions;
	
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	
	private String[] courses;
	
	private String batchTiming;
	

	//initialize the constructor 
	public Professor() {
		
		//initialize the values for gender drop-down list.
		genderOptions = new LinkedHashMap<>();
		genderOptions.put("MALE", "Male");
		genderOptions.put("FEMALE", "Female");
		genderOptions.put("Others", "Other");
		
		//initialize the values for country drop-down list.
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("IN", "India");
		countryOptions.put("BR", "Brazil");
		countryOptions.put("EN", "England");
		countryOptions.put("US", "United state of America");
		countryOptions.put("CAD", "Canada");
		
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getCourses() {
		return courses;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	public LinkedHashMap<String, String> getGenderOptions() {
		return genderOptions;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public String getBatchTiming() {
		return batchTiming;
	}
	public void setBatchTiming(String batchTiming) {
		this.batchTiming = batchTiming;
	}
	
}
