package com.springdemo.ioc.mobile;

import org.springframework.stereotype.Component;


@Component //in this case bean id --> androidPhone [first letter of class is in lower case.]
public class AndroidPhone implements Mobile {

	@Override
	public String getMyMobile() {
		return "This is my android phone";
	}

}
