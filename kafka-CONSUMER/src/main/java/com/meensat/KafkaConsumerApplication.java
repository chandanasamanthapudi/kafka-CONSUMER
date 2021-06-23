package com.meensat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meensat.entity.User;

@SpringBootApplication
@RestController
public class KafkaConsumerApplication {
	
	List<String> messages = new ArrayList<>();

	User userFromTopic = null;
	
	
	@GetMapping("/consumeStringMessage")
	public List<String> consumeMsg() {
		return messages;
	}
	

	@GetMapping("/consumeJsonMessage")
	public User consumeJsonMessage() {
		return userFromTopic;
	}
	
	@KafkaListener(groupId = "Chandana-1", topics = "Chandana", containerFactory = "kafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data) {
		messages.add(data);
		return messages;
	}
	
	@KafkaListener(groupId = "Chandana-2", topics = "Chandana", containerFactory = "userKafkaListenerContainerFactory")
	public User getJsonMsgFromTopic(User user) {
		userFromTopic = user;
		return userFromTopic;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

}
