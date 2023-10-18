package com.name.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

	
	@GetMapping
	@RequestMapping("/api/name")
	public String getname() {
		return "name from name api";
	}
	
}
