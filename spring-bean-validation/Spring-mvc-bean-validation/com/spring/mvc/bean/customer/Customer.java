package com.spring.mvc.bean.customer;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.custom.annotation.MyCustomAnnotation;

/**
 * This is model/bean class of customer.
 * we will apply hibernate bean validation rule here using hibernate annotation.
 * @author raviranjan
 *
 */
public class Customer {

	@NotNull(message="required field")
	@Size(min=1, message="min 1 charecter is required")
	private String firstName;
	
	@NotNull(message="required field")
	private String lastName;
	
	@NotNull
	@Min(value=0, message="value must be gratter than or equal to 0")
	@Max(value=10, message="value must be less than or equal to 10")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{6}", message="postal code must be six digits")
	private String postalCode;
	
	@MyCustomAnnotation
	private String myCustomeAnnotation;
	
	public String getMyCustomeAnnotation() {
		return myCustomeAnnotation;
	}
	public void setMyCustomeAnnotation(String myCustomeAnnotation) {
		this.myCustomeAnnotation = myCustomeAnnotation;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String furstName) {
		this.firstName = furstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
}
