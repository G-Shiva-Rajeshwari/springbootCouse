package com.gsrr.ExampleApplication;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	//@GetMapping("/hello")
	public String sayHello() {
		return "hello from my first Controller";
	}
	
	@GetMapping("/hello-2")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String sayHello2() {
		return "hello from my sec Controller";
	}
	
	@GetMapping("/hello/{user-name}")
	public String pathVar(@PathVariable("user-name") String userName) {
		return "my value = "+userName;
	}
	
	//http://localhost:8080/hello?param_name=paramvalue&param_name_2=value_2
	@GetMapping("/hello")
	public String paramVar(@RequestParam("user-name") String userName, 
			@RequestParam("user-Lastname") String userLastname) {
		return "my value = "+userName+" "+userLastname;
	}
	@PostMapping("/post")
	public String post(@RequestBody String msg) {
		return "Request accepted and msg is:"+msg;
	}
	
	@PostMapping("/post-order")
	public String post(@RequestBody Order order) {
		return "Request accepted and msg is:"+order.toString();
	}
	
	@PostMapping("/post-order-record")
	public String postReocrd(@RequestBody OrderRecord order) {
		return "Request accepted and msg is:"+order.toString();
	}
}
