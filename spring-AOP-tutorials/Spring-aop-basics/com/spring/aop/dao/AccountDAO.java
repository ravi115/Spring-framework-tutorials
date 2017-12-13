package com.spring.aop.dao;

import org.springframework.stereotype.Component;

import com.spring.aop.pojo.Accounts;

/**
 * Target Object
 * @author raviranjan
 *
 */
@Component
public class AccountDAO {

	public void addAccount(Accounts theAccount, boolean vipPerson) {
		System.out.println(getClass() + " : " + "My DB Work : " + " Add an Account");
	}
	
	
	public void doWork() {
	
		System.out.println(getClass() + " : doing my work.." );
	}
}
