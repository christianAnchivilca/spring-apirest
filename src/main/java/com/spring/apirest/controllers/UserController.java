package com.spring.apirest.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.json.JSONParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;


import com.spring.apirest.models.entity.User;
import com.spring.apirest.models.entity.UserDatos;
import com.spring.apirest.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	
	
	@Autowired
	UserService userService;
	
	@PostMapping(value="/",produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Object> getTodoUser() {
	
	     
		List<UserDatos> datos = userService.getUsers();
		List<Object> datosNuevos= new ArrayList<Object>();
		
	      for(int i=0;i<datos.size();i++) {
 	   
		    datosNuevos.add("<"+datos.get(i).getId()+">/<"+datos.get(i).getFirst_name()+">"+"/<"+datos.get(i).getEmail()+">");
         }

		return datosNuevos;
		 
		
		
	}

}
