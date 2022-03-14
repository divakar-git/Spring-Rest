package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;

@RestController
public class CustomerOperationsController {
	
	@PostMapping("/register")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer cust) {
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
}
