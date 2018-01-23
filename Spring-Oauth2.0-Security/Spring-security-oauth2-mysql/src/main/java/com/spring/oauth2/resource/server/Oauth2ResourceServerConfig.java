package com.spring.oauth2.resource.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * Resource server of Oauth2 Spring
 * @author raviranjan
 *
 */
@Configuration
@EnableResourceServer
public class Oauth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

	/**
	 * 
	 * at the time of API version we can identify the set of API with Resource_Id.
	 * based on Resource_Id, we will allow client to access the particular version of REST API.  
	 * 
	 */
	/*
	 * Optional, if we don't have more than one Version of API. 
	 * 
	 */
	private static final String RESOURCE_ID = "rest_api";
	
	
	/**
	 * configure HttpSecurity
	 * allow the REST API URI starts with root REST API of the Resources.
	 * The below resources are only accessible by ADMIN role. not others roles.
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.anonymous()
				.disable()
			.requestMatchers()
				.antMatchers("/rest/**")
			.and()
			.authorizeRequests()
				.antMatchers("/rest/**")
				.access("hasRole('ADMIN')")
			.and()
			.exceptionHandling()
				.accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

	/**
	 * configure resources.
	 * makes resources should  have state now onwards.
	 * 
	 */
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID).stateless(false);
		
		/*
		 * in case if we don't have any resource Id 
		 */
		//resources.stateless(false);
	}

	
	
	
}
