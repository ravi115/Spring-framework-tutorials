package com.spring.mvc.html.form;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.model.professor.Professor;

/**
 * This class provide the options from model class itself. 
 * @author raviranjan
 *
 */
@Controller
@RequestMapping("/professor")
public class ProfessorContollers {

	/*
	 * we use key-value pair data structure to map properties field.  
	 */
	@Value("#{batchtime}")
	private HashMap<String, String> batchTimings;
	
	/**
	 * This is method is to display HTML form for professor after binding model with professor class
	 * and properties file.
	 * @param model model for professor class.
	 * @return jsp page.
	 */
	@RequestMapping("/showform")
	public String showForm(Model model) {
		//create professor object.
		Professor prof = new Professor();
		
		//add this professor object into model
		model.addAttribute("professor", prof);
		
		//add properties file data to model.
		model.addAttribute("batchtime", batchTimings);
		
		//invoke professor-form.jsp page.
		return "professor-form";
	}
	
	/**
	 * This resource is to just re-direct onto confirmation JSP page.
	 * @param prof
	 * @return
	 */
	@RequestMapping("/processform")
	public String processForm(@ModelAttribute("professor") Professor prof) {
		
		//print out the professor data onto console.
		System.out.println(prof.getFirstName() + " : " + prof.getLastName());
		
		//invoke professor-confirmation.jsp page.
		return "professor-confirmation";
	}
}
