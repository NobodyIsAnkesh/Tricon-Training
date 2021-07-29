package com.example.demoMongoDB.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoMongoDB.model.UserModel;
import com.example.demoMongoDB.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	public String createUser(String uname, String password, String email, BigInteger contact) {
		UserModel userModel = new UserModel(uname, password, email, contact);
		userRepo.save(userModel);
		return ("New user created with ID: "+ userModel.getId());
	}
	
	public String updateUser(String id) {
		
	}
	
	public List<UserModel> listUsers(){
		return userRepo.findAll();
	}
}
