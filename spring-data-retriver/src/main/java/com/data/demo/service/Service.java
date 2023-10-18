package com.data.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.data.demo.entity.Person;
import com.data.demo.entity.scheme;
import com.data.demo.exception.ElementNotFoundException;
import com.data.demo.repo.Repo;

@org.springframework.stereotype.Service
public class Service {
    
	@Autowired
	private static Repo repo;

	public static void save(List<Person> users) {
		try {
			repo.saveAll(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public List<scheme> findAll(){
		return repo.findAll();
	}

	public List<scheme> findById(Integer id) throws ElementNotFoundException {
		// TODO Auto-generated method stub
		Optional<scheme> res = repo.findById(id);
		if(res == null) return new ArrayList<scheme>();
		
		return (List<scheme>) res.get();
	}
	
}
