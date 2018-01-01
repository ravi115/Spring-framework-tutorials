package com.jersey.spring.server.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.web.filter.RequestContextFilter;

/**
 * 
 * @author raviranjan
 *
 */
//this is same <servlet-mapping></servlet-mapping> of web.xml
@ApplicationPath("/api") 
public class AppConfig extends ResourceConfig {

	/**
	 * This is constructor of this class to initialize the required component.
	 */
	public AppConfig() {
		//The below package is same as <init-param></init-param> of web.xml.
		packages("com.jersey.spring.server.resource");

		/** 
		 *  == Optional Not required ======== 
		 */
		register(RequestContextFilter.class);

		/**
		 *  This is also optional 
		 */
		property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
	}
}