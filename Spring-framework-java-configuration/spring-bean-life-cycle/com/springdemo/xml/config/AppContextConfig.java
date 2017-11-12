package com.springdemo.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springdemo.life.fruits.Fruits;
import com.springdemo.life.fruits.OrangeFruits;

/**
 * This class is just java source code of XML based configuration.
 * @author raviranjan
 *
 */

@Configuration //this annotation tells spring container that this is a configuration class.
/*
* 1. The below annotation is same as {componenet:scan} in xml file. it let's the spring container loads
*    all the classes available in the package specified in its argument. 
* 
* 2. The @componentScan is optional. if we want all classes form any package to be loaded in spring 
* 	container then only we should provide @componenetScan.
* 
* 3. in this case @component is not required still to demonstration purpose it is given. 
*/
@ComponentScan("com.springdemo.life.fruits") 
public class AppContextConfig {

	/**
	 * @Bean annotation is used to actually crate the bean class object of desired class.
	 * 
	 * The method chosen for this bean creation is the actual bean-id. by this bean-id spring container
	 * invokes this class.
	 * 
	 * @return the objects of bean class to spring container.
	 * 
	 */
	@Bean
	public Fruits MyOrangeFruits() {
		return new OrangeFruits();
	}
}
