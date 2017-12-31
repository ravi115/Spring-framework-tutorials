package com.spring.restful.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mongodb.MongoClient;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.trakinvest")
public class WebConfig extends WebMvcConfigurerAdapter {

	//create a mongodb factory which establish connection with mongodb
		@Bean
		public MongoDbFactory mongoDbFactory() throws Exception {
			return new SimpleMongoDbFactory(new MongoClient("127.0.0.1", 27017), "trakinvest");
		}
		
		//create a mongodb template
		@Bean
		public MongoTemplate mongoTemplate() throws Exception {
			
			MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
			return mongoTemplate;
		}
}
