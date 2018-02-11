package com.jersey.spring.jdbc.server.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.jersey.spring.jdbc")
public class SpringDataSourceConfig {

	@Bean
	public DataSource dataSource() {
		System.out.println("<---- ** Initializing datasource ** ----->");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//MySQL database we are using
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/training");//change url
		dataSource.setUsername("root");//change userid
		dataSource.setPassword("root");//change pwd
		return dataSource;
	}
	
	@Bean
    public JdbcTemplate jdbcTemplate() {
		
		System.out.println("<---- ** connecting through JDBC Template ** ----->");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
 
}
