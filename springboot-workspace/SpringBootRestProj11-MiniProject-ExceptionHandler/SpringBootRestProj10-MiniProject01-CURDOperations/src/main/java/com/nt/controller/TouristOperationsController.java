package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristManagementService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {

	@Autowired
	private ITouristManagementService service;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {

		try {
			String resultMsg = service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in tourist enrollment", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourists() {
		try {
			List<Tourist> list = service.fetchAllTourists();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in fetching tourists", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable Integer id) {
		try {
			Tourist tourist = service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) {
		try {
			String msg = service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTourist(@PathVariable Integer id) {
		try {
			String msg = service.deleteTourist(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable Integer id,
			@PathVariable("hike") Float hikePercent) {
		try {
			String msg = service.updateTouristBudgetById(id, hikePercent);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
