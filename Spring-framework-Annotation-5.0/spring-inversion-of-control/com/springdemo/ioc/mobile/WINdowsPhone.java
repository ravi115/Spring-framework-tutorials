package com.springdemo.ioc.mobile;

import org.springframework.stereotype.Component;

@Component //in this case bean id -->WINdowsPhone {exact similar to class name. 
				//since first and second both the character are in upper case.} 
public class WINdowsPhone implements Mobile {

	@Override
	public String getMyMobile() {
		return "This is my windows phone";
	}

}
