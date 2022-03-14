package com.nt.runner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumingRunner_PostingJSONData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumingRunner_PostingJSONData.run()");
		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:4041/actor/register";
		
		String json_body = "{\"aid\":1002,\"name\":\"divakar\",\"age\":30.0,\"type\":\"hero\"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(json_body, headers);
		
		ResponseEntity<String> response = template.exchange(serviceUrl, 
															HttpMethod.POST, 
															entity, 
															String.class);
		
		System.out.println("Response Body(output):: " + response.getBody());
		System.out.println("Response Status code value :: " + response.getStatusCodeValue());
		System.out.println("Response Status code:: " + response.getStatusCode().name());
		System.out.println("Response Headers:: " + response.getHeaders().toString());
		
		/*Object obj = template.getForObject(serviceUrl, String.class);
		System.out.println("Response Body(output):: " + obj);*/
		//System.exit(0);
	}

}
