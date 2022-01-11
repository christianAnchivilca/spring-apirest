package com.spring.apirest.service;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;




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

}
