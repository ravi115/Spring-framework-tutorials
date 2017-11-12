package com.spring.mvc.html.basics;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * This class is illustrate how many ways to read a HTML form data and also to display the data.
 * 
 * @author raviranjan
 *
 */

@Controller
public class HelloWorldController {

	/*need to create controller method to show HTML form page.
	 * this method is available @ /showform url.
	 */
	@RequestMapping("/showform")
	public String showHTMLForm() {
		return "helloworld-form";
	}

	//need to create controller method to process HTML form.
	@RequestMapping("/processform/v1")
	public String processHTMLForm1() {
		return "helloworld";
	}

	//new controller to read data
	//add data to model
	@RequestMapping("/processform/v2")
	public String processHTMLForm2(HttpServletRequest request, Model model) {

		//read from data from HTML page
		String studentName = request.getParameter("student");

		//convert the String to all upper case
		studentName = studentName.toUpperCase();

		//create a message for student
		String result = "Hello! " + studentName;

		/*
		 * add message to controller
		 * this model used to ship data from front-end to controller and controller to front-end.
		 *
		 */
		model.addAttribute("message", result);

		return "helloworld";
	}

	//new controller to read data
	//add data to model
	@RequestMapping("/processform/v3")
	public String processHTMLForm3(
			//the spring container reads the form data.
			@RequestParam("username") String studentName, 
			Model model) {

		//convert the String to all upper case
		studentName = studentName.toUpperCase();

		//create a message for student
		String result = "Hello Buddy- ! " + studentName;

		//add message to controller
		model.addAttribute("message", result);

		return "helloworld";
	}

}
