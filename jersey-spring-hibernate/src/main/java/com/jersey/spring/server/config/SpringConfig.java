package com.jersey.spring.server.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jersey.spring.server.model.Motor;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.jersey.spring.server")
public class SpringConfig {

	/**
	 * Configure data sources.
	 * @return
	 */
	@Bean
	public DataSource getDatasource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/motorbikes");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}

	/**
	 * configure session factory to get the session factory of the application 
	 * @return
	 * @throws IOException
	 */
	@Bean
	public SessionFactory getSessionFactory() throws IOException{

		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setAnnotatedClasses(Motor.class);
		//sessionFactoryBean.setAnnotatedClasses(Address.class);
		sessionFactoryBean.setHibernateProperties(getHibernateProperties());
		sessionFactoryBean.setDataSource(getDatasource());
		sessionFactoryBean.afterPropertiesSet();

		return sessionFactoryBean.getObject();
	}

	/**
	 * properties to be applied to configure a successful hibernate connection to mySQL 
	 * @return
	 */
	private static Properties getHibernateProperties() {

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.put("hibernate.show_sql", false);
		//hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		// other properties

		return hibernateProperties;
	}

	/**
	 *  configure transaction 
	 * @return
	 * @throws IOException
	 */
	@Bean
	public HibernateTransactionManager getTransactionManager() throws IOException{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory());

		return transactionManager;
	}
}
