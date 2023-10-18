package com.micro.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServiceDiscoveryApplication.class, args);
	}

}
