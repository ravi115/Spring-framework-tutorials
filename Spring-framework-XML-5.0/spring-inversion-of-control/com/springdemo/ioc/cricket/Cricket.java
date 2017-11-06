package com.springdemo.ioc.cricket;

import com.springdemo.ioc.coach.Coach;

public class Cricket implements Coach {

	@Override
	public String getInstruction() {
		
		return "Practice bating....";
	}

}
