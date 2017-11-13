package com.spring.mvc.bean.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is a controller class. here we are mapping a resource with root path.
 * means this resource is available at localhost:port/top-level-directory/mapping-url in servlet-mapping.
 * 
 * @author raviranjan
 */

/*
 *@controller annotation converts this class to a controller class for spring container. 
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String showMyPage() {
		
		/*the return string tells the spring container to display the main-menu.jsp page when this 
		 * this resource is being accessed.
		 */
		return "main-menu";
	}
}
