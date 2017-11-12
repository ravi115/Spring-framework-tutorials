package com.springdemo.di.os;

import org.springframework.stereotype.Component;

@Component //in this case bean id -->WINdowsPhone {exact similar to class name. 
				//since first and second both the character are in upper case.} 
public class WINdowsPhone implements OperatingSystem {

	@Override
	public String getOS() {
		return "windows OS is used in this phone";
	}

}
