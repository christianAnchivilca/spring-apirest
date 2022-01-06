package com.spring.apirest.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.apirest.models.entity.User;
import com.spring.apirest.models.entity.UserDatos;
import com.spring.apirest.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/",produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, 
            method = RequestMethod.GET)
	public void getTodoUser() {
	     
		 userService.getUsers();
		
		 
		
		
	}

}
