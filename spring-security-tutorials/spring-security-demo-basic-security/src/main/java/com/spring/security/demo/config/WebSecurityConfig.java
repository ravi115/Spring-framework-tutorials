package com.spring.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//add our user for  in memory authentication

		/** Employee roles*/
		auth.inMemoryAuthentication()
		.withUser("ravi").password("1234").roles("EMPLOYEE");

		/** Manager*/
		auth.inMemoryAuthentication()
		.withUser("ranjan").password("12345").roles("MANAGER");

		/** Admin*/
		auth.inMemoryAuthentication()
		.withUser("monu").password("123").roles("ADMIN");

	}

	/*
	 * after security version-5, we should use our password Encoder. 
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
