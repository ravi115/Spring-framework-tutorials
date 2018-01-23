package com.spring.oauth2.application.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ApplicationRESTController {

	@GetMapping
	public String greetings() {
		return "hello word";
	}
}
