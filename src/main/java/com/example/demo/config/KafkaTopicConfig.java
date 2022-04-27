package com.example.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
/** Topics are categories used to organize messages
 */
public class KafkaTopicConfig {

	@Bean
	public NewTopic exampleTopic() {
		return TopicBuilder.name("twitter").build();
	}
}
