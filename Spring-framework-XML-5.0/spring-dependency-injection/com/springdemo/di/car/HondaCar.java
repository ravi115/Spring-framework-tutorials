package com.springdemo.di.car;

import com.springdemo.di.engine.Engine;
import com.springdemo.di.factory.CarFactory;

public class HondaCar implements CarFactory {

	/*
	 * This variable will be set using properties file injection concept. 
	 * 
	 */
	private String ownerName;
	private String ownerMobile;

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	private Engine engine;
	
	public String getOwnerMobile() {
		return ownerMobile;
	}

	public void setOwnerMobile(String ownerMobile) {
		this.ownerMobile = ownerMobile;
	}

	@Override
	public String getCar() {
		return "This is Honda car";
	}

	@Override
	public String getEngine() {
		return engine.getEngine();
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

}
