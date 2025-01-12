package com.CibilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import com.CibilService.model.CustomerDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class CibilServiceApplication {
	@Autowired
	KafkaTemplate<String,String> template;
	@Autowired
	ObjectMapper om;

	public static void main(String[] args) {
		SpringApplication.run(CibilServiceApplication.class, args);
	}

	
	@KafkaListener(topics = "LoanApplication-topic",groupId ="loan2-group",containerFactory = "kafkaListenerContainerFactory")
	public void getLoanApplication(String json) throws JsonMappingException, JsonProcessingException {
		System.out.println("LoanApplication-topic       "+json);
		int generateCibilScore=758;// api call cibil
		
	
		CustomerDetails cd=om.readValue(json,CustomerDetails.class);
		     
		    cd.setCibilCode(generateCibilScore);

		  if(generateCibilScore>750) {
			  cd.setCibilStatus("Approve");
		  }else {
			  cd.setCibilStatus("Reject");
		  }
		    
      String jsondata=om.writeValueAsString(cd);		
		 
      template.send("cibil-topic",jsondata);
		
      System.out.println("send cibil-topic  "+jsondata);
		
	}
}
