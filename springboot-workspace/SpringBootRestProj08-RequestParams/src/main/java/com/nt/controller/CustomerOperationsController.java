package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOperationsController {

	@GetMapping("/report")
	public String reportData(@RequestParam("cno") String no, @RequestParam(required = true) String cname) {
		return no + " " + cname;
	}

}
