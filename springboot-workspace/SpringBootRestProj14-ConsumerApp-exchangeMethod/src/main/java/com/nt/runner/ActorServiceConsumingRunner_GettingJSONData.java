package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;

@Component
public class ActorServiceConsumingRunner_GettingJSONData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumingRunner_GettingJSONData.run()");
		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:4041/actor/find";

		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);

		System.out.println("Response Body(output):: " + response.getBody());
		System.out.println("Response Status code value :: " + response.getStatusCodeValue());
		System.out.println("Response Status code:: " + response.getStatusCode().name());
		System.out.println("Response Headers:: " + response.getHeaders().toString());

		/*Object obj = template.getForObject(serviceUrl, String.class);
		System.out.println("Response Body(output):: " + obj);*/
		// System.exit(0);

		String jsonBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Actor actor = mapper.readValue(jsonBody, Actor.class);
		System.out.println("Actor :: " + actor);

		System.out.println("===============================================");
		serviceUrl = "http://localhost:4041/actor/findAll";
		ResponseEntity<String> response1 = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);

		System.out.println("Response Body(output):: " + response1.getBody());
		System.out.println("Response Status code value :: " + response1.getStatusCodeValue());
		System.out.println("Response Status code:: " + response1.getStatusCode().name());
		System.out.println("Response Headers:: " + response1.getHeaders().toString());
		
		String jsonBody1 = response1.getBody();
		ObjectMapper mapper1 = new ObjectMapper();
		Actor[] actors = mapper1.readValue(jsonBody1, Actor[].class);
		
		List<Actor> listActors = Arrays.asList(actors);
		System.out.println("response body as List<Actor> object's data:: " + listActors);
		listActors.forEach(System.out::println);
		
		List<Actor> listActors1 = mapper1.readValue(jsonBody1, new TypeReference<List<Actor>>() {});
		System.out.println("============================");
		listActors1.forEach(System.out::println);
	}

}
