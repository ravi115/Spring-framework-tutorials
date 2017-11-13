package com.spring.mvc.bean.controllers;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.bean.customer.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerControllers {

	/* add initbinder annotation to convert trim input string.
	 * @InitBinder works as a pre-processor ways.
	 * This annotation basically trim out all leading and trailer whitespace from the string.
	 * if string contains only white-spaces then it trims all the white space and make it null.
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor  = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	@RequestMapping("/showform")
	public String showForm(Model model) {

		//bind customer object with model and add to model
		model.addAttribute("customer", new Customer());

		return "customer-form";
	}

	@RequestMapping("/processform")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer,
			BindingResult theBindingResult) {

		//This is how we test if any whitespace brakes the rule for validation. 
		System.out.println("the First name : |" + customer.getFirstName() + "|");
		
		//to trace the errors and no of error code
		System.out.println("The Binding error " + theBindingResult);
		
		//check if there is an error in binding result.
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}else {
			return "customer-cinfirmation";	
		}
	}
}
