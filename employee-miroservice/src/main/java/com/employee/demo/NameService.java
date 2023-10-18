package com.employee.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameService {
	
	@Autowired
	private RestTemplate resttemp;
	
	@Autowired
	private CircuitBreakerFactory cbf;
	
	@Bean
	public RestTemplate resttemplate() {
		return new RestTemplate();
	}
	public String callnameservice() {
		
		CircuitBreaker cb = cbf.create("nameservicebreaker");
		
		return cb.run(() -> resttemp.getForObject("http://localhost:8081/api/name", String.class),throwable -> "Fall back service");
//		String name = resttemp.getForObject("http://localhost:8081/api/name", String.class);
//		return name;
	}
	public String fallbackSer() {
		return "Fall back service";
	}
	
}
