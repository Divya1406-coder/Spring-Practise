package com.data.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.data.demo.entity.Person;
import com.data.demo.entity.scheme;
import com.data.demo.exception.ElementNotFoundException;
import com.data.demo.service.Service;

@RestController
public class Controller {
	
	@Autowired // -> automatic object creation process dispose
	private Service service;
	
	@GetMapping("/add")
	public List<scheme> add(@RequestBody List<Person> person) throws ElementNotFoundException {
		return service.save(person);
	}
	
	/*
	Generics - Integer, String, Character, Float, Double, byte
	 
	XML  - tags <></>
	
	JSON Javascript Object Notation - Object { }
	
	*/
	
	
	@GetMapping("/getAllDetails")
	public List<scheme> getAllValues() {
		return service.findAll();
	}
	
	
	@GetMapping("/getbyId/{id}")
	public List<scheme> getAllValues(@PathVariable("id") Integer id) throws ElementNotFoundException {
		return service.findById(id);
	}
    
	
}
