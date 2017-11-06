package com.springdemo.di.car;

import com.springdemo.di.engine.Engine;
import com.springdemo.di.factory.CarFactory;

public class AudiCar implements CarFactory {

	private Engine engine;

	@Override
	public String getCar() {
		return "This is Audi CAR";
	}
	/*
	 * Inject dependency using setter method. 
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String getEngine() {
		return engine.getEngine();
	}

}
