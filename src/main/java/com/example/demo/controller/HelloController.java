package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


	@GetMapping("/hello")
	public String helloMessage() {
		return "Hello Spring Boot! Here i am!";
	}
	
}


//https://medium.com/danielpadua/java-spring-boot-eclipse-7a1c4c364839


