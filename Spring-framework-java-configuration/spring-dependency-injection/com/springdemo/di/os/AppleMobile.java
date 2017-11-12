package com.springdemo.di.os;

import org.springframework.stereotype.Component;

/**
 * This class is a bean class.
 * using @component annotation we will identity this bean class.
 * There are three mechanism used by spring container to create the bean.
 * 1. @component --> spring container uses the default class name as bean id with first letter in lower case.
 * 2. @component("beanId") --> spring container identifies this bean class using beanId argument passed 
 * in @component.
 * 3. if class name letter starts with capital and if the second letter is also capital then spring
 * container uses exact class name as bean id. 
 *
 * @author raviranjan
 */
@Component("MyApplePhone") // in this case bean id --> MyApplePhone 
public class AppleMobile implements OperatingSystem {

	@Override
	public String getOS() {
		return "IOS OS is used in the this phones";
	}

}
