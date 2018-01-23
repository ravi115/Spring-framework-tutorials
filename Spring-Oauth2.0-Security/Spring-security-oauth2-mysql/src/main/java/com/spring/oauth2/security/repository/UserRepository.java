package com.spring.oauth2.security.repository;

import com.spring.oauth2.security.model.User;

public interface UserRepository {

	User findByName(String username);
}
