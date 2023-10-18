package com.micro.home;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HomeConfig {
	
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		RestTemplate tmp = new RestTemplate();

		return tmp;
	}
}
