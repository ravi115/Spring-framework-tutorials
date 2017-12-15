package com.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aop.pojo.Users;

/**
 * Target Object
 * @author raviranjan
 *
 */
@Component
public class UserDAO {

	
	//add a new method : findUsers()
	public List<Users> findUsers() {
		
		List<Users> myUsers = new ArrayList<>();
		Users users1 = new Users("ravi", "duke");
		Users users2 = new Users("ranjan", "tvs");
		Users users3 = new Users("monu", "r15");
		Users users4 = new Users("salman", "hero");
		
		myUsers.add(users1);
		myUsers.add(users2);
		myUsers.add(users3);
		myUsers.add(users4);
		
		return myUsers;
	}
	
	public void addAccount(Users theUser, boolean vipPerson) {
		System.out.println(getClass() + " : " + "My DB Work : " + " Add an Account");
	}
	
	
	public void doWork() {
	
		System.out.println(getClass() + " : doing my work.." );
	}
}
