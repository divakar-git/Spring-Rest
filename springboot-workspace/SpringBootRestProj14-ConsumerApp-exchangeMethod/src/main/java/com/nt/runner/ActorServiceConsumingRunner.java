package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumingRunner.run()");

		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:4041/actor/wish";
		
		ResponseEntity<String> resp = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		
		System.out.println("response body(output):: " + resp.getBody());
		System.out.println("response status code:: " + resp.getStatusCode());
		System.out.println("response status code value:: " + resp.getStatusCodeValue());
		System.out.println("response headers:: " + resp.getHeaders().toString());
		
		//System.exit(0);
	}

}
