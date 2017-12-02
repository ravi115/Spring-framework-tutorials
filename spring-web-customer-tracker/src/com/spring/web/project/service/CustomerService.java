package com.spring.web.project.service;

import java.util.List;

import com.spring.web.project.entity.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);

	public void deleteCustomer(int theId);
}
