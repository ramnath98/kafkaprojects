package com.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}


@KafkaListener(topics = "LoanApplication-topic",groupId ="loan-group",containerFactory = "kafkaListenerContainerFactory")
	public void getLoanApplication(String json) {
		System.out.println("LoanApplication-topic  main send      "+json);
		
	}
	

@KafkaListener(topics = "LoanApprove-topic",groupId ="loan-group",containerFactory = "kafkaListenerContainerFactory")
public void getLoanApplicationApprove(String json) {
	System.out.println("LoanAProve-topic send mail       "+json);
	
}
	
}
