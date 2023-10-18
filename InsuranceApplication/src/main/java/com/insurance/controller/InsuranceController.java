package com.insurance.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entity.User;
import com.insurance.repo.InsuranceRepo;

@RestController
public class InsuranceController {
	
	@Autowired(required=true)
	private InsuranceRepo repo;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
//		a.add(user);
		repo.save(user);
		return "User Added Successfully: " + user;
	}
	
	@GetMapping("/getUser")
	public List<User> getUser(){
		return repo.findAll();
	}
}
