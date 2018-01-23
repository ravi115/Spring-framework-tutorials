package com.spring.oauth2.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.oauth2.security.model.CustomUserDetails;
import com.spring.oauth2.security.model.User;
import com.spring.oauth2.security.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = userRepository.findByName(userName);
		
		if(user == null){
            throw new UsernameNotFoundException("UserName "+userName+" not found");
        }
		return new CustomUserDetails(user);
	}

}
