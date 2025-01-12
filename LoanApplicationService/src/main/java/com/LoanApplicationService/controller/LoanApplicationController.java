package com.LoanApplicationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoanApplicationService.model.CustomerDetails;
import com.LoanApplicationService.service.LoanApplicationServiceI;

@RestController
public class LoanApplicationController {
  @Autowired
	LoanApplicationServiceI lsi;
	
	@PostMapping("/customer")
	public String saveCustomer(@RequestBody CustomerDetails c) {

		return lsi.saveCustomer(c);
	}
}
