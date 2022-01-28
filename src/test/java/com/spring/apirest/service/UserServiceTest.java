package com.spring.apirest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.spring.apirest.models.entity.User;
import com.spring.apirest.models.entity.UserDatos;
import com.spring.apirest.repository.UserRepository;
import com.spring.apirest.repository.UserRepositoryTest;


//@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@Mock
	RestTemplate restTemplate;

	
	 @InjectMocks
	 UserService userService;
	 
	 
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
	void testGetUsers() {

		 List<UserDatos> lista= new ArrayList<>();
		 
		 
		 UserDatos datos=new UserDatos();
		 User user =new User();
		 user.setPage(6);
		 
		 datos.setId(1);
		 datos.setEmail("george.bluth@reqres.in");
		 datos.setFirst_name("George");
		 datos.setLast_name("Bluth");
		 lista.add(datos);

	        when(restTemplate.exchange(
	                "https://reqres.in/api/users",HttpMethod.GET,entity,
	                User.class)).thenReturn(new ResponseEntity(user, HttpStatus.OK));
	        
	        
	      
	       
		assertEquals(user.getPage(),6);
	
	}
	

	@Test
	void testTranform() {

		 List<UserDatos> lista= new ArrayList<>();
		 
		 
		 UserDatos datos=new UserDatos();
		 User user =new User();
		 user.setPage(6);
		 
		 datos.setId(1);
		 datos.setEmail("george.bluth@reqres.in");
		 datos.setFirst_name("George");
		 datos.setLast_name("Bluth");
		 lista.add(datos);

	     
	        
	      System.out.println("dataTransform:"+userService.dataTransform(lista).size());
	       
		assertEquals(2, userService.dataTransform(lista).size());
	
	}

}
