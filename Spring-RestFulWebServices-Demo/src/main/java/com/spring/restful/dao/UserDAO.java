package com.spring.restful.dao;

import java.util.List;

import com.spring.restful.model.Followers;
import com.spring.restful.model.User;

public interface UserDAO {

	public List<User> listUser();
	
	public void add(final User user);
	
	public List<User> getFollowers(final String email);
	
	public void followUser(final Followers followers);
	
	public boolean isUserExist(User user);
}
