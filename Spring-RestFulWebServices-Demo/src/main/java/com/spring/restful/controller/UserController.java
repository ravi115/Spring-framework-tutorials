package com.spring.restful.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restful.model.Followers;
import com.spring.restful.model.User;
import com.spring.restful.service.UserService;
import com.spring.restful.validator.RequestValidator;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/users", 
			method=RequestMethod.GET, 
			produces = "application/json")
	@ResponseBody
	public List<User> getAllUser() {
		System.out.println("GET invoked..");
		List<User> user = userService.listUser();
		for(User u : user) {
			System.out.println("User is : \n " + u);
		}
		return user;
	}

	@RequestMapping(value="/user", 
			method=RequestMethod.POST, 
			headers="accept=application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public User addUser(@RequestBody User user) {

		System.out.println("POST is invoked..");
		System.out.println(user);

		if(RequestValidator.isValidRequest(user) && !userService.isUserExist(user)) {
			user.setId(UUID.randomUUID().toString());
			userService.add(user);
		}

		return null;
	}

	@RequestMapping(value="/user/follow", 
			method=RequestMethod.POST, 
			headers="accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void followUser(@RequestBody Followers followers) {
		System.out.println("Follow is invoked..");
		if(RequestValidator.isValidRequest(followers)) {

			userService.followUser(followers);
		}

	}

	@RequestMapping(value="/user/followers", 
			method=RequestMethod.GET, 
			headers="accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<User> getAllFollowers(@RequestParam("email") String email) {

		List<User> user = null;
		System.out.println("followers is invoked..");
		if(RequestValidator.isValidRequest(email)) {

			user = userService.getFollowers(email);
		}
		return user;
	}
}
