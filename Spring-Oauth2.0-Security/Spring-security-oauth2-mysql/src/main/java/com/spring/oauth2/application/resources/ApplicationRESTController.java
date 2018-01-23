package com.spring.oauth2.application.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ApplicationRESTController {

	@RequestMapping(value="/greet")
	public String greetings() {
		return "hello word";
	}
}
