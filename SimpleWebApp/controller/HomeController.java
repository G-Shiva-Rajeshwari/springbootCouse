package com.gsrr.SimpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/greet")
public String greet() {
	return "welcome";
}
	@RequestMapping("/about")
	public String about() {
		return "hello from about";
	}
}
