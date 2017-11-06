package com.springdemo.di.car;

import com.springdemo.di.engine.Engine;
import com.springdemo.di.factory.CarFactory;

public class MarutiCar implements CarFactory {

	/*
	 *inject literals dependency 
	 */
	private String name;
	private String email;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private Engine engine;
	@Override
	public String getCar() {
		return "This is maruti car";
	}

	@Override
	public String getEngine() {
		return engine.getEngine();
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

}
