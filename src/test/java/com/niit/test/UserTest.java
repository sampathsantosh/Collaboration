/*package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.DAO.UserDAO;
import com.niit.config.DbConfig;
import com.niit.model.User;


@ComponentScan("collbackend")
@Ignore
public class UserTest {
static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("collbackend");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
 @Ignore
	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setUserId(1003);
		user.setFirstName("santhosh");
		user.setLastName("m");
		user.setEmailId("santhoshreddy182@gmail.com");
		user.setPassword("12345");
		user.setRole("user");
		user.setStatus("N");
		user.setIsOnlime("Y");
		assertTrue("Problem in Inserting User",userDAO.addUser(user));
	
	}
	
	@Ignore
	@Test
	public void updateUser()
	{
User user=new User();
user.setUserId(1003);
user.setFirstName("santhu");
user.setLastName("m");
user.setEmailId("santhu@gmail.com");
user.setPassword("12345");
user.setRole("user");
user.setStatus("Y");
user.setIsOnlime("Y");
assertTrue("Problem in Inserting User",userDAO.updateUser(user));

	}
	
	@Ignore
	@Test
	public void getUserTest(){
		User user=(User)userDAO.getUser(3);
		
		System.out.println("FirstName:" + user.getFirstName());
		System.out.println("Role:" +user.getRole());
		
		assertNotNull("user not found", user);
	}
	
@Ignore
	@Test
	public void deleteUserTest(){
		User user=(User)userDAO.getUser(3);
		assertTrue("Problem in deletion",userDAO.deleteUser(user));
	}
@Ignore
	@Test
	public void approveUserTest(){
		User user=(User)userDAO.getUser(1003);
		assertTrue("Problem in approving",userDAO.approveUser(user));
	}
	@Ignore
	@Test
	public void getAllUserTest(){
		List<User> userList=(List<User>)userDAO.getAllusers();
		assertNotNull("User list not found ",userList.get(0));
		for(User user:userList)
		{
			System.out.println("UserID:"+user.getUserId() + "FirstName:"+user.getFirstName());
		}
	}
		
	}*/