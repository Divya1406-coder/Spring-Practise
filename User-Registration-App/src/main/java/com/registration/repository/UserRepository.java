package com.registration.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.registration.entity.User;


public class UserRepository {
	List<User> repo = new ArrayList<>();
	
	@Bean
	public void save(User user) {
		repo.add(user);
		System.out.println(user);
	}
}
