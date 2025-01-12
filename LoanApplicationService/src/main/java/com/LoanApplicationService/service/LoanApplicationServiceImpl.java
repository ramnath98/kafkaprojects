package com.LoanApplicationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.LoanApplicationService.model.CustomerDetails;
import com.LoanApplicationService.repositary.CustomerDetailsRepositary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LoanApplicationServiceImpl  implements LoanApplicationServiceI{

	@Autowired
	CustomerDetailsRepositary cdr;
	@Autowired
	KafkaTemplate<String,String> kafkaTemplate;
	
	@Autowired
	ObjectMapper om;
	
	@Override
	public String saveCustomer(CustomerDetails c) {
		 CustomerDetails cd=cdr.save(c);
		 String json;
		try {
			json = om.writeValueAsString(cd);
			 kafkaTemplate.send("LoanApplication-topic",json);
		} catch (JsonProcessingException e) {
		  return "User Not Register";
		}
		
		return "User Register successfully"; 
	}

}
