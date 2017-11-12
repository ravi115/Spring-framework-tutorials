package com.spring.mvc.html.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.model.student.Student;

/**
 * This class total fetch data from form  tag itself.
 * no option  is provided by java model class
 * 
 * @author raviranjan
 *
 */
@Controller
@RequestMapping("/student")
public class StudentControllers {

	/* this resource is to display student form.
	 * This method binds the student class and HTML form.
	 * as we know before calling front end to access this resource this 
	 * resource is actually being executed first. 
	 * 
	 */
	@RequestMapping("/showform")
	public String showForm(Model model ) {
		
		//create a student object assign it to model.
		Student student = new Student(); 
		
		//add this student object to model so that we can retrieve the student data from model.
		model.addAttribute("student", student);
		
		//invokes the student-form.jsp pages.
		return "student-form";
	}
	
	/**
	 * This method is retrieve the form data using model attribute annotation.
	 * @param student this is model class.
	 * @return jsp page to display the student details.
	 */
	@RequestMapping("/processform")
	public String processForm(@ModelAttribute("student") Student student) {
		
		//print the data
		System.out.println(student.getFirstName() + " : " + student.getLastName());
		
		return "student-confirmation";
	}
}
