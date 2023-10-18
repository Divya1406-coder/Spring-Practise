package com.value.annotation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${message}")
	private String msg;
	
	//setting default value to the Properties files
	@Value("${msg : default message}")
	private String msg1;
	//accessing list of values
	@Value("${name.list}")
	private String[] list;
	//accessing map values;
	@Value("#{${mapvalues}}")
	private Map<String,Integer> map;
	
	@GetMapping("/hello")
	public String sayHello() {
		return msg;
	}
	@GetMapping("/list")
	public String[] listval() {
		return list;
	}
	@GetMapping("/map")
	public Map<String,Integer> mapval() {
		return map;
	}
	
}
