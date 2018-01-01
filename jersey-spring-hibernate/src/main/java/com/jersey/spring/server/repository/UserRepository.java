package com.jersey.spring.server.repository;

import java.util.List;

import com.jersey.spring.server.model.Motor;

public interface UserRepository {

	public Motor getMotorCycle(int id);
	public List<Motor> getAllMotorBikes();
	public void save(Motor motorBikes);
	
}
