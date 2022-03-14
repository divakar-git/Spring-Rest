package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOperationsController {
	
	@GetMapping("/report/101/raja")
	public String fetchData1(@PathVariable(name = "cname", required=false) String name,
			@PathVariable(required=false) Integer no) {
		return "from FetchData1";
	}
	
	@GetMapping("/report/{no}/{cname}")
	public String fetchData2(@PathVariable(name = "cname", required=false) String name,
			@PathVariable(required=false) Integer no) {
		return "from FetchData2";
	}
	
	/*	@GetMapping("/report/101/raja")
		public String fetchData3(@PathVariable(name = "cname", required=false) String name,
				@PathVariable(required=false) Integer no) {
			return "from FetchData3";
		}*/
	
	/*	@GetMapping("/report/{no}/cname")
		public String fetchData2(@PathVariable(name = "cname", required=false) String name,
				@PathVariable(required=false) Integer no) {
			return "from FetchData2";
		}
		
		@GetMapping("/report/{no}/{cname}")
		public String fetchData3(@PathVariable(name = "cname", required=false) String name,
				@PathVariable(required=false) Integer no) {
			return "from FetchData3";
		}
		
		@GetMapping("/report/no/{cname}")
		public String fetchData4(@PathVariable(name = "cname", required=false) String name,
				@PathVariable(required=false) Integer no) {
			return "from FetchData4";
		}*/



}
