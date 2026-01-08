package com.gsrr.SimpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@RequestMapping
	public void login() {
		System.out.println("kindly login");
	}
}
