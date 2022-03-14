package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
public class CustomerOperationsController {
	
	/*@GetMapping("/report")
	public ResponseEntity<Customer> showData() {
		Customer cust = new Customer(1001, "raja", 367883.f);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Customer>(cust, status);
	}*/
	
	@GetMapping("/report1")
	public ResponseEntity<Customer> showData() {
		Customer cust = new Customer(1001, "raja", 367883.66f,
				new String[]{"red", "green", "blue"},
				List.of("10th", "10+2", "B.Tech"),
				Set.of(53484399L,3189434L,3149834L),
				Map.of("adhar", 3893914L, "panNo", 8934891340L),
				new Company("SAMSUNG", "hyd", "Electronics", 4000));
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Customer>(cust, status);
	}

}
