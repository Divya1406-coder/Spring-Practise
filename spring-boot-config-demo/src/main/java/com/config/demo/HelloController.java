package com.config.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private ApiConfig api;

	@GetMapping("/hello")
	public String sayHello() {
		return api.getHost()+" "+api.getPort()+" "+api.getTimeout();
	}
}
