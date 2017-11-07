package com.springdemo.di.os;

import org.springframework.stereotype.Component;


@Component //in this case bean id --> androidPhone [first letter of class is in lower case.]
public class AndroidPhone implements OperatingSystem {

	@Override
	public String getOS() {
		return "Android OS is used in this phones";
	}

}
