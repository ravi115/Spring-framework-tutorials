package com.springdemo.ioc.tenis;

import com.springdemo.ioc.coach.Coach;

public class Tenis implements Coach {

	@Override
	public String getInstruction() {
		
		return "Practice tenis";
	}

}
