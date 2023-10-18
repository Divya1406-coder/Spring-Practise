package com.kafka.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/{message}")
public class HelloController {
	@Autowired
	private KafkaTemplate<String, String> kafkatemp;
	
	@GetMapping
	public String publish(@PathVariable("message") String message) {
		kafkatemp.send("test",message);
		return "message send: " + message;
	}
}
