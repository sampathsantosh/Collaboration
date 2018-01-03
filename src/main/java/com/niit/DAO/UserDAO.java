package com.niit.DAO;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {

	public boolean addUserDetail(User user);
	public boolean updateOnlineStatus(String status, User user);
	public User getByEmail(String email);
	public List<User> getAllUserDetails();
	public User getUserDetails(String username);
/*	public boolean checkLogin (User userDetail);*/
}
