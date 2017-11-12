package com.springdemo.di.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springdemo.di.os.OperatingSystem;

/**
 * This is example setter injection.
 * @author raviranjan
 *
 */
@Component
public class IPhone8 implements Mobile {

	private OperatingSystem os;
	
	/*
	 *injected dependency using setter. 
	 */
	@Autowired(required=true)
	@Qualifier("MyApplePhone")
	public void setOs(OperatingSystem os) {
		this.os = os;
	}
	
	@Override
	public String getMobile() {
		return "This is IPHONE 8";
	}

	@Override
	public String getMobileOS() {
		return os.getOS();
	}

}
