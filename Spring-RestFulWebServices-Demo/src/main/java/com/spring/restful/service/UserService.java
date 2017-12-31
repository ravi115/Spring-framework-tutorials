package com.spring.restful.service;

import java.util.List;

import com.spring.restful.model.Followers;
import com.spring.restful.model.User;

public interface UserService {

	public List<User> listUser();

	public void add(final User user);

	public List<User> getFollowers(final String email);

	public void followUser(final Followers followers);

	public boolean isUserExist(User user);
}
