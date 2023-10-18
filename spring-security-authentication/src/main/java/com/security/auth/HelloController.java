package com.security.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String SayHelloAll() {
		return "hello world";
	}
	
	@GetMapping("/user")
	public String sayHelloUser() {
		return "Hello user"; 
	}
	
	@GetMapping("/admin")
	public String sayHelloAdmin() {
		return "Hello Admin"; 
	}
	
	
	
}
