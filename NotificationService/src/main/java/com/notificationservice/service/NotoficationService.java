package com.notificationservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotoficationService {

	
	@KafkaListener(topics = "LoanApplication-topic",groupId ="loan-group",containerFactory = "kafkaListenerContainerFactory")
	public void getLoanApplication(String json) {
		System.out.println("LoanApplication-topic       "+json);
	}
	
}
