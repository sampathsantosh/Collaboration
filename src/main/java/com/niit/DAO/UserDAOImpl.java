package com.niit.DAO;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;


@Repository
public  class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDAO userDAO;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean addUserDetail(User user) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:" +e);
		return false;
		}	
	}
	@Transactional
	public boolean updateOnlineStatus(String status, User user) {
		// TODO Auto-generated method stub
		try
		{
		user.setIsOnline(status);
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:" +e);
		return false;
		}	
	}
	@Transactional
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return (User)sessionFactory.getCurrentSession().get(User.class, email);
	}
	@Transactional
	public List<User> getAllUserDetails() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List<User> user=(List<User>)session.createQuery("from User").list();
		session.close();
		return user;

	}
@Transactional
	public User getUserDetails(String username) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,username);
		session.close();
		return user;
	}

}

