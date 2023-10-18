package com.kafka.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
	@KafkaListener(topics = "test", groupId = "consume-group")
	public void consume(String message) {
		System.out.println("Message Consumed : "+message);
	}
}
