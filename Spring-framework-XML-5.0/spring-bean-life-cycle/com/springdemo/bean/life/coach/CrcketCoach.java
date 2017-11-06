package com.springdemo.bean.life.coach;

/**
 * This class demonstrate the life cycle of bean.
 * @author raviranjan
 *
 */
public class CrcketCoach implements Coach {

	@Override
	public String getWorkDone() {
		return "Play cricket";
	}
	/*
	 *This is init method of bean life cycle.
	 *the init method must be {public void}
	 *the init method should not accept any argument. 
	 * 
	 */
	public void initBeanMethod() {
		System.out.println("bean init method is called");
	}
	/*
	 * same rule is applied for destroy method of bean life cycle. 
	 */
	public void destroyBeanMethod() {
		System.out.println("bean destroy method");
	}

}
