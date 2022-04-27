package com.example.demo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/messages")
public class MessageController {
	
	private KafkaTemplate<String, String> kafkaTemplate;
  
	@PostMapping
	public void publish(@RequestBody MessageRequest request) {
		kafkaTemplate.send("twitter", request.getMessage());
	}
}
