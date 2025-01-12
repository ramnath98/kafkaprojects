package com.loanapproveservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class LoanApproveServiceApplication {
	
	@Autowired
	ObjectMapper om;
	
	@Autowired
	KafkaTemplate<String,String> template;

	public static void main(String[] args) {
		SpringApplication.run(LoanApproveServiceApplication.class, args);
	}

	
	
	@KafkaListener(topics = "cibil-topic",groupId ="loanApprove-group",containerFactory = "kafkaListenerContainerFactory")
	public void getCibilScore(String json) throws JsonMappingException, JsonProcessingException {
		System.out.println("LoanApprove-topic       "+json);
		
		CustomerDetails cd=om.readValue(json,CustomerDetails.class);
		cd.setLoanStatus("Approve");
		
		String jsondata=om.writeValueAsString(cd);
		
		template.send("LoanApprove-topic",jsondata);
		
		
	}
	
}
