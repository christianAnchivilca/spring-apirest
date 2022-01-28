package com.spring.apirest.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.spring.apirest.models.entity.User;
import com.spring.apirest.models.entity.UserDatos;

@Repository
public class UserRepository {
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${miUrl}")
	private String url;
	
	
	public List<UserDatos> getDatos(){
		
		
		 List<UserDatos> lista= new ArrayList<>();
			try {
		 HttpHeaders headers = new HttpHeaders();
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        
	        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
		        ResponseEntity<User> response =restTemplate.exchange("https://reqres.in/api/users", HttpMethod.GET, entity, User.class);
		        
		        User body = response.getBody();
		        
		        lista= body.getData();
		      


			   } catch (Exception ex) {
		           ex.printStackTrace();

		        }
		  return lista;
	
	}

}
