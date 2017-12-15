package com.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aop.pojo.Producer;

/**
 * Target Object
 * @author raviranjan
 *
 */
@Component
public class ProducreDAO {

	
	//add a new method : findUsers()
	public List<Producer> findUsers(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("I have thrown some Exception.");
		}
		
		List<Producer> myUsers = new ArrayList<>();
		Producer users1 = new Producer("ravi", "duke");
		Producer users2 = new Producer("ranjan", "tvs");
		Producer users3 = new Producer("monu", "r15");
		Producer users4 = new Producer("salman", "hero");
		
		myUsers.add(users1);
		myUsers.add(users2);
		myUsers.add(users3);
		myUsers.add(users4);
		
		return myUsers;
	}
	
	public void addAccount(Producer theUser, boolean vipPerson) {
		System.out.println(getClass() + " : " + "My DB Work : " + " Add an Account");
	}
	
	
	public void doWork() {
	
		System.out.println(getClass() + " : doing my work.." );
	}
}
