package com.spring.web.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.web.project.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the hibernate session factory.
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getAllCustomers() {
		
		//get the hibernate current session
		Session session = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		//execute the query and get the result 
		List<Customer> customers = query.getResultList();
		
		//return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		//get the current session
		Session session = sessionFactory.getCurrentSession();
		
		//save the customer
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//now retrive the customer from data using the primary key [id]
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public Void delete(int theId) {
		
		//get the current session
		Session session = sessionFactory.getCurrentSession();
		
		//delete the customer with primary key which has passed in
		@SuppressWarnings("rawtypes")
		Query theQuery = session.createQuery("delete from Customer where id=:theCustomerId");
		
		theQuery.setParameter("theCustomerId", theId);
		
		//delete the customer
		theQuery.executeUpdate();
		return null;
	}

}
