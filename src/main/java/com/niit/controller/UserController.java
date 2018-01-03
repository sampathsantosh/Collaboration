package com.niit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.UserDAO;
import com.niit.model.User;


@RestController
public class UserController {
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/getAllUsers")
	public List <User> getAllUser(){
		return userDAO.getAllUserDetails();
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<?> registerUser(@RequestBody User user){

		user.setRole("user");
		if(userDAO.addUserDetail(user))
		{
			
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in registration",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<User> loginStatus(@RequestBody User userDetail)
	{
		userDetail=userDAO.getByEmail(userDetail.getEmailId());
		if((userDetail==null))
		{
			userDetail=new User();
			System.out.println("user email invalid");
		}
		else
		{
			System.out.println("login user");
		}
		return new ResponseEntity<User>(userDetail,HttpStatus.OK);
	}
}