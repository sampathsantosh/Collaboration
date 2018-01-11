package com.niit.controller;




import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.UserDAO;
import com.niit.model.UsersDetails;



@RestController
public class UserController {
	
	@Autowired 
	UserDAO userDAO;
	
	
	@RequestMapping(value="/getAllUsers")
	public List <UsersDetails> getAllUser(){
		return userDAO.getAllUserDetails();
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<?> registerUser(@RequestBody UsersDetails userDetail){

		userDetail.setRole("user");
		if(userDAO.addUserDetail(userDetail))
		{
			
			return new ResponseEntity<UsersDetails>(userDetail,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in registration",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
		@PostMapping("/login")
		public ResponseEntity<?> loginStatus(@RequestBody UsersDetails userDetail,HttpSession session)
	{
			UsersDetails user=userDAO.getUserDetails(userDetail.getUsername());
			//select * from UserDetails where username='piyush';
			
			boolean userExists = userDAO.checkLogin(user.getUsername(), user.getPassword());
			
			
			System.out.println(userExists);
			
			
			
			System.out.println(userDetail.getUsername());
			
			System.out.print(userExists);
			
			if (userExists) 
			{
				userDAO.updateOnlineStatus("Y",user);
				session.setAttribute("user",user);
				return new ResponseEntity<UsersDetails>(user, HttpStatus.OK);
			} 
			else {
				Error error = new Error("unable to login user details");
				return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
		 
		}
	

		
	@GetMapping(value = "/logout/{username}")
	public ResponseEntity<String> loggingout(@PathVariable("username") String username,HttpSession session) {
		
		
		UsersDetails user=userDAO.getUserDetails(username);
		//select * from UserDetails where username='piyush';
		
		boolean userExists = userDAO.checkLogin(user.getUsername(), user.getPassword());
		
		
		System.out.println(userExists);
		
		
		
		System.out.println(username);
		
		System.out.print(userExists);
		
		if (userExists) 
		{
			userDAO.updateOnlineStatus("N",user);
			session.removeAttribute("user");
			return new ResponseEntity<String>("Logout succesfully", HttpStatus.OK);
		} 
		else {
			Error error = new Error("unable to login user details");
			return new ResponseEntity<String>("Unable to logout", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	 
	}

}

