package com.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aop.pojo.Consumers;

/**
 * Target Object
 * @author raviranjan
 *
 */
@Component
public class ConsumersDAO {

	
	//add a new method : findUsers()
	public List<Consumers> findUsers(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("I have thrown some Exception.");
		}
		
		List<Consumers> myUsers = new ArrayList<>();
		Consumers users1 = new Consumers("ravi", "duke");
		Consumers users2 = new Consumers("ranjan", "tvs");
		Consumers users3 = new Consumers("monu", "r15");
		Consumers users4 = new Consumers("salman", "hero");
		
		myUsers.add(users1);
		myUsers.add(users2);
		myUsers.add(users3);
		myUsers.add(users4);
		
		return myUsers;
	}
	
	public void addAccount(Consumers theUser, boolean vipPerson) {
		System.out.println(getClass() + " : " + "My DB Work : " + " Add an Account");
	}
	
	
	public void doWork() {
	
		System.out.println(getClass() + " : doing my work.." );
	}
}
