package com.spring.web.project.dao;

import java.util.List;

import com.spring.web.project.entity.Customer;

/**
 * This is the standard ways to create DAO class.
 * @author raviranjan
 *
 */
public interface CustomerDAO {

	/**
	 * Return List of customers.
	 * @return
	 */
	public List<Customer> getAllCustomers();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);

	public Void delete(int theId);
}
