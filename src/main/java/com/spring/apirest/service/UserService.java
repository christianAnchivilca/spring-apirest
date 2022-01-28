package com.spring.apirest.service;


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
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.apirest.models.entity.User;
import com.spring.apirest.models.entity.UserDatos;
import com.spring.apirest.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;


     public List<UserDatos>  getUsers(){
    	
    	 List<UserDatos> lista= new ArrayList<>();
    	 lista = repo.getDatos();
    	 
    	 return lista;
    	
   
     }
     
     public List<String> dataTransform(List<UserDatos> datos){
    	 List<String> datosNuevos= new ArrayList<String>();
 		
	      for(int i=0;i<datos.size();i++) {
	   
		    datosNuevos.add(datos.get(i).getId()+","+datos.get(i).getFirst_name()+","+datos.get(i).getEmail());
        }
	      
	      return datosNuevos;

     }
     
     
    

}
