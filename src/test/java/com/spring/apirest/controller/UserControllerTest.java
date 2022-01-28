package com.spring.apirest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.spring.apirest.controllers.UserController;
import com.spring.apirest.service.UserService;


@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	MockMvc mvc;

	@MockBean
	UserService userService;
	
	
	@Test
	public void testGetTodoUser() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/users/userdatos"))
		        .andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
		        .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty())
		        .andDo(MockMvcResultHandlers.print());	
		
	}

}
