package com.spring.apirest.controllers;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.apirest.models.entity.UserDatos;
import com.spring.apirest.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	
	
	@Autowired
	UserService userService;
	
	@PostMapping(value="/",produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> getTodoUser() {
	
		List<UserDatos> datos = userService.getUsers();
		List<String> datosNuevos= userService.dataTransform(datos);
		return datosNuevos;
		 
	}
	
	@GetMapping(value = "/userdatos")
	public UserDatos getAllUser()
	{
		
		UserDatos datos=new UserDatos();
		 datos.setId(1);
		 datos.setEmail("george.bluth@reqres.in");
		 datos.setFirst_name("George");
		 datos.setLast_name("Bluth");
		return datos;
	}

}
