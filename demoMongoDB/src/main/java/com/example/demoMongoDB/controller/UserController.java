package com.example.demoMongoDB.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoMongoDB.service.UserService;

@RestController
@RequestMapping(value="/users",method=RequestMethod.GET)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public String creatUser(
			@RequestParam("username") String uname,
			@RequestParam("password") String password,
			@RequestParam("emailId") String email,
			@RequestParam("contact") BigInteger contact
			) {
		return userService.createUser(uname, password, email, contact);
	}
	@PutMapping(value = "/{id}")
	public String updateUser(@PathVariable(name = "id") String id) {
		return userService.updateUser(id);
	}
	
	@GetMapping("/list")
	public List<?> listUsers(){
		return userService.listUsers();
	}
}
