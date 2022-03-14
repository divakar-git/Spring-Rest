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
import com.nt.exception.TouristNotFoundException;
import com.nt.service.ITouristManagementService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {

	@Autowired
	private ITouristManagementService service;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) throws Exception {

		/*try {
			String resultMsg = service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in tourist enrollment", HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		String resultMsg = service.registerTourist(tourist);
		return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourists() throws Exception {
		/*try {
			List<Tourist> list = service.fetchAllTourists();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in fetching tourists", HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		List<Tourist> list = service.fetchAllTourists();
		return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable Integer id) throws TouristNotFoundException {
		/*try {
			Tourist tourist = service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		System.out.println("TouristOperationsController.displayTouristById() --- before");
		Tourist tourist = service.fetchTouristById(id);
		System.out.println("TouristOperationsController.displayTouristById() --- after");
		return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);

	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) throws Exception {
		/*		try {
					String msg = service.updateTouristDetails(tourist);
					return new ResponseEntity<String>(msg, HttpStatus.OK);
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
				}*/
		
		String msg = service.updateTouristDetails(tourist);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTourist(@PathVariable Integer id) throws Exception {
		/*try {
			String msg = service.deleteTourist(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}*/
		String msg = service.deleteTourist(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable Integer id,
			@PathVariable("hike") Float hikePercent) throws Exception {
		/*try {
			String msg = service.updateTouristBudgetById(id, hikePercent);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}*/
		String msg = service.updateTouristBudgetById(id, hikePercent);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
