package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumingRunner_PathVariables implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		/*		RestTemplate template = new RestTemplate();
				String serviceUrl = "http://localhost:4041/actor/wish/{id}/{name}";
				ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class, Map.of("name", "rajesh", "id", 1001));
				
				System.out.println("Response Body(output):: " + response.getBody());
				System.out.println("Response Status code value :: " + response.getStatusCodeValue());
				System.out.println("Response Status code:: " + response.getStatusCode().name());
				System.out.println("Response Headers:: " + response.getHeaders().toString());
				
				Object obj = template.getForObject(serviceUrl, String.class);
				System.out.println("Response Body(output):: " + obj);
				System.exit(0);*/
	}

}
