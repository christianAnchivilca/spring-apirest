package com.spring.apirest.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.spring.apirest.models.entity.User;
import com.spring.apirest.models.entity.UserDatos;



@Service
public class UserService {
	
	@Autowired
	RestTemplate restTemplate;

	

	
     public void  getUsers(){
    	
    	
    	 try {
    		   HttpHeaders headers = new HttpHeaders();
               headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
               headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
               headers.setContentType(MediaType.APPLICATION_JSON);
               HttpEntity<Object> entity = new HttpEntity<Object>(headers);
               final String uri = "https://reqres.in/api/users";
          
                
             
               
               ResponseEntity<User> response = 
            		   restTemplate.exchange(uri, HttpMethod.GET, entity, User.class);
               
               User body = response.getBody();
               
               List<UserDatos> datos= body.getData();
               
               for(int i=0;i<datos.size();i++) {
            	   
            	   System.out.println("<"+datos.get(i).getId() +">/"+"<"+datos.get(i).getLast_name() +">/"+"<"+datos.get(i).getEmail() +">,");
               }
      
         } catch (Exception ex) {
            ex.printStackTrace();

         }
    	 
    	
   
     }

}
