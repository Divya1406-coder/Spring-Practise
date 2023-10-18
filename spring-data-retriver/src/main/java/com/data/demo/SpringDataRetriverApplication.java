package com.data.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.data.demo.entity.scheme;
import com.data.demo.service.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringDataRetriverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRetriverApplication.class, args);
	}
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<scheme>> typeReference = new TypeReference<List<scheme>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("https://api.mfapi.in/mf");
			try {
				List<scheme> users = mapper.readValue(inputStream,typeReference);
				Service.save(users);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
}
