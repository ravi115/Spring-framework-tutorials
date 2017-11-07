package com.springdemo.di.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springdemo.di.os.OperatingSystem;

/**
 * This is the example of literals or field dependency injection.
 * @author raviranjan
 *
 */
@Component
public class Lumiya800Phone implements Mobile{

	/*
	 * injected dependency using field. 
	 */
	@Autowired
	@Qualifier("WINdowsPhone")
	private OperatingSystem os;
	
	@Override
	public String getMobile() {
		return "This is Lumiya 800 phone";
	}

	@Override
	public String getMobileOS() {
		return os.getOS();
	}

}
