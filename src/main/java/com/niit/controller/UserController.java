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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.DAO.ProfilePictureDAO;
import com.niit.DAO.UserDAO;
import com.niit.model.ProfilePicture;
import com.niit.model.UsersDetails;



@RestController
public class UserController {
	
	@Autowired 
	UserDAO userDAO;
	

	@Autowired
	ProfilePictureDAO profilePictureDAO;	
	
	
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
				session.setAttribute("username", user.getUsername());
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
			session.removeAttribute("username");
			return new ResponseEntity<String>("Logout succesfully", HttpStatus.OK);
		} 
		else {
			Error error = new Error("unable to login user details");
			return new ResponseEntity<String>("Unable to logout", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	 
	}
	
	@PostMapping("/doUpload")
	public ResponseEntity<?> uploadProfilePicture(@RequestParam(value="file") CommonsMultipartFile fileUpload,HttpSession session)
	{
		
		UsersDetails users=(UsersDetails)session.getAttribute("username");
		if(users==null)		{
			   Error error=new Error("UnAuthorized user");
				return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		} 
		ProfilePicture profilePicture=new ProfilePicture();
		profilePicture.setUsername(users.getUsername());
		profilePicture.setImage(fileUpload.getBytes());
		profilePictureDAO.saveProfilePicture(profilePicture);
		return new ResponseEntity<UsersDetails>(users,HttpStatus.OK);
	}
		
		
		@GetMapping(value="/getimage/{username}")
		public @ResponseBody byte[] getProfilePic(@PathVariable String username,HttpSession session){
			UsersDetails user=(UsersDetails)session.getAttribute("username");
			if(user==null)
				return null;
			else
			{
				ProfilePicture profilePic=profilePictureDAO.getProfilePicture(username);
				if(profilePic==null)
					return null;
				else
					return profilePic.getImage();
			}
			
	}
		
		/*System.out.println("uploading picture");
		ProfilePicture profilePicture=new ProfilePicture();
		profilePicture.setUsername("swetha");
		System.out.println(fileUpload.getBytes());	
		System.out.println("picture uploaded");
		profilePicture.setImage(fileUpload.getBytes());
		profilePictureDAO.save(profilePicture);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}	
	@GetMapping(value="/getImage/{username}")
	public @ResponseBody byte[] getProfilePic(@PathVariable("username")String username,HttpStatus session)
	{
		ProfilePicture profilePicture=profilePictureDAO.getProfilePicture(username);
		return profilePicture.getImage();
	}*/
	
}

