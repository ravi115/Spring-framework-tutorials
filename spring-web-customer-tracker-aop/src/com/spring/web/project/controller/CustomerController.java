package com.spring.web.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.project.entity.Customer;
import com.spring.web.project.service.CustomerService;

/**
 * This is customer controller.
 * @author raviranjan
 *
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject Customer Service
	@Autowired
	private CustomerService customerService;
	
	/*
	 *@RequestMapping(path="/list", method=RequestMethod.GET)
	 * the above complete annotation is equivalent to @getMapping("/urlPath");
	 *only GET type request will accepted and rest of the data will be rejected. 
	 * 
	 */
	@GetMapping("/list")
	public String listCustomers(Model model) {
		System.out.println("controller invoked");
		
		//get the customer from dao
		List<Customer> customers = customerService.getAllCustomers();
		
		//add the customer into spring model
		model.addAttribute("customers", customers);
		
		return "list-customer";
	}
	
	/*
	 * call to show the form : showFormForAdd 
	 */
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		//create a new model attribute to bind form data
		Customer customer = new Customer();
		
		//add customer to model
		model.addAttribute("customer", customer);
		
		//call form jsp page.
		return "customer-form";
	}
	
	/*
	 *Read the form data 
	 */
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		System.out.println("save form data is called..");
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int theId, Model model) {
		
		System.out.println("update is called");
		
		//get the customer from service.
		Customer customer  = customerService.getCustomer(theId);
		
		//set the model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		
		//send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		
		//delete the customer
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}

