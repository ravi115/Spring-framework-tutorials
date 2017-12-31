package com.spring.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restful.dao.UserDAO;
import com.spring.restful.model.Followers;
import com.spring.restful.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> listUser() {
		
		return userDAO.listUser();
	}

	@Override
	public void add(User user) {
		userDAO.add(user);
		
	}

	@Override
	public List<User> getFollowers(String email) {
		return userDAO.getFollowers(email);
	}

	@Override
	public void followUser(Followers followers) {
		userDAO.followUser(followers);
		
	}

	@Override
	public boolean isUserExist(User user) {
		return userDAO.isUserExist(user);
	}
	
	

}
