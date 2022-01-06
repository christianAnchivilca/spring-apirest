package com.spring.apirest.service;

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
		
		User u = new User();
		u.setPage(1);
		u.setTotal(12);
          
		   when(restTemplate.exchange("https://reqres.in/api/users", HttpMethod.GET,entity,User.class))
		   .thenReturn(new ResponseEntity(u, HttpStatus.OK));
		   
		   
		
	}

}
