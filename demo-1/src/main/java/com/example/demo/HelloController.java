package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	@Value("${spring.datasource.url}")
	private String dburl;
	
	@GetMapping("/hello")
	public String sayHello() {
		return dburl;
	}
}
