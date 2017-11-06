package com.springdemo.di.car;

import com.springdemo.di.engine.Engine;
import com.springdemo.di.factory.CarFactory;

public class BMWCar implements CarFactory {

private Engine engine;
	
	/*
	 * dependency injection using constructor. 
	 */
	public BMWCar(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public String getCar() {
		return "This is BMW CAR";
	}
	
	@Override
	public String getEngine() {
		return engine.getEngine();
	}
}
