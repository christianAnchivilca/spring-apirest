package com.spring.apirest.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import javax.servlet.http.HttpFilter;

import org.apiguardian.api.API;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.spring.apirest.models.entity.User;

public class UserRepositoryTest {
	
	@Mock
	RestTemplate restTemplate;
	
	@InjectMocks
	private UserRepository userRepo;
	
	HttpHeaders headers = new HttpHeaders();
	HttpEntity<Object> entity;
    
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		entity = new HttpEntity<Object>(headers);
	}
	
	@Test
	void testConection() {
		
		ResponseEntity<User> status = new ResponseEntity<>(HttpStatus.OK);
		 
		
		when(restTemplate.exchange("https://reqres.in/api/users", HttpMethod.GET, entity, User.class))
		.thenReturn(status);
		
		ResponseEntity<User> response =restTemplate.exchange("https://reqres.in/api/users", HttpMethod.GET, entity, User.class);
		
		System.out.println("test: "+response.getStatusCode());
		
		assertEquals(status.getStatusCode(),response.getStatusCode());

	}
	
	@Test
	void testConectionBad() {
		
		ResponseEntity<User> status = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 
		
		when(restTemplate.exchange("https://reqres.in/api/users", HttpMethod.GET, entity, User.class))
		.thenReturn(status);
		
		ResponseEntity<User> response =restTemplate.exchange("https://reqres.in/api/users", HttpMethod.GET, entity, User.class);
		
		System.out.println("test: "+response.getStatusCode());
		
		assertEquals(status.getStatusCode(),response.getStatusCode());

	}

}
