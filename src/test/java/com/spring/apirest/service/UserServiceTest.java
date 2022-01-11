package com.spring.apirest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.Arrays;

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

public class UserServiceTest {
	
	@Mock
	RestTemplate restTemplate;
	
	@InjectMocks
	private UserService userService;
	
	HttpHeaders headers = new HttpHeaders();
	HttpEntity<Object> entity;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		 headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         headers.setContentType(MediaType.APPLICATION_JSON);
         entity= new HttpEntity<Object>(headers);
	}
	
	@Test
	void getUsers() {
		
	
          
		 when(userService.getUsers().get(0).getEmail()).thenReturn("george.bluth@reqres.in");

		    String result = userService.getUsers().get(0).getEmail();

		    assertEquals("george.bluth@reqres.in", "incorrect@gmail.com", result);

		    verify(userService.getUsers().get(0).getEmail());
		   
		   
		
	}

}
