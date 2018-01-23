package com.spring.oauth2.security.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.oauth2.security.model.Role;
import com.spring.oauth2.security.model.User;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public User findByName(String username) {
		
		//Session session = sessionFactory.getCurrentSession();
		
		System.out.println("Trying this query----->from user where user_name = :name\n\n");
		/*
		String hql = "FROM User u WHERE u.user_name = :name";
		
		User user = session.createQuery(hql, User.class)
							.setParameter("name", username)
							.getSingleResult();
		
		*/
		
		User user = getUser();
		
		System.out.println("The user is : " + user);
		return user;
	}

	private User getUser() {
		
		User user  = new User();
		
		List<Role> roles = new ArrayList<>();
		Role role = new Role();
		
		
		role.setRoleId(1);
		role.setRole("USER");
		roles.add(role);
		
		user.setRoles(roles);
		user.setId(11);
		user.setEmail("ravi115ranjan@gmail.com");
		user.setActive(1);
		user.setName("ravi");
		user.setPassword("ravi1234");
		
		
		
		return user;
	}
}
