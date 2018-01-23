package com.spring.oauth2.authorization.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Authorization server is responsible to verify the user credentials.
 * 
 * if credentials are correct then it generates the token [refresh-token + access token].
 * 
 * it also contains the information about registered clients and their possible access scope and 
 * grant types.
 * 
 * 
 * @author raviranjan
 *
 */

@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	/*
	 * definition -1 : 
	 * For a web application, a realm is a complete database of users and groups,
	 * that identify valid users of a web application (or a set of web applications) 
	 * and are controlled by the same authentication policy.
	 * 
	 * Definition -2
	 * A realm is a security policy domain defined for a web or application server. 
	 * A realm contains a collection of users, who may or may not be assigned to a group.
	 * 
	 */
	private static final String REALM = "REALM";

	/**
	 * This TokenStore is used to store the tokens.
	 */
	@Autowired
	private TokenStore tokenStore;

	/**
	 * This UserApproval handler handles the user request. 
	 */
	@Autowired
	private UserApprovalHandler userApprovalHandler; 

	/**
	 * 
	 */
	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * configure EndPoints
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		endpoints
		.tokenStore(tokenStore)
		.userApprovalHandler(userApprovalHandler)
		.authenticationManager(authenticationManager);
	}

	/**O
	 * Configure Security
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

		security.realm(REALM + "/client");
	}

	/**
	 * configure Clients
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients
		.inMemory()
		.withClient("ClientID")   //provide client ID --> can be hard coded
		.secret("secret_code")   // secret key can also be hard coded.
		.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
		.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
		.scopes("read", "write", "trust")
		.accessTokenValiditySeconds(120) //120 seconds means 2 minutes token validity.
		.refreshTokenValiditySeconds(60);  // only for 1 minutes the refresh token will valid.
	}


	/**
	 * we must provide password encoder after spring security 5.0.0
	 */
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	/*@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}*/

}
