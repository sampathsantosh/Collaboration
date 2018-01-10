package com.niit.DAO;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UsersDetails;




@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDAO userDAO;
	
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addUserDetail(UsersDetails user) {
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:" +e);
		return false;
		}	
	}
@Transactional
	public boolean updateOnlineStatus(String status, UsersDetails user) {
		/*try
		{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(user);
		tx.commit();
		return true;
		}*/
		try{
			user.setStatus(status);
		sessionFactory.getCurrentSession().update(user);
			return true;
			
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:" +e);
		return false;
		}	
	}
	@Transactional
public UsersDetails getByEmail(String email) {
		String hql = "from UsersDetails where email='" + email + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UsersDetails> list = query.list();

		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Transactional
	public List<UsersDetails> getAllUserDetails() {
		Session session=sessionFactory.openSession();
		List<UsersDetails> user=(List<UsersDetails>)session.createQuery("from UsersDetails").list();
		session.close();
		return user;
	}


    @Transactional
	public UsersDetails getUserDetails(String username) {
    	String hql = "from UsersDetails where username='" + username + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UsersDetails> list = query.list();

		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}



  /*  @Transactional
	public boolean checkLogin(UsersDetails userDetail) {
		try{
			Session session=sessionFactory.openSession();
			
			Query query=session.createQuery("from UsersDetails where username=? and password=?");
		//	Query query=session.createQuery("from UsersDetails where email=:email and password=:password");
			query.setParameter("username",userDetail.getUserName());
			query.setParameter("password",userDetail.getPassword());
			UsersDetails user=(UsersDetails)query.list().get(0);
			if(user==null)
			{
				return false;
			}
			else
			{
				return true;
			}
	     	}     catch(Exception e){
			    
	     		return false;
		}
	}
	}
*/
    public boolean checkLogin(String username, String password){
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY =" from UsersDetails as o where o.username=? and o.password=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,username);
		query.setParameter(1,password);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}

		session.close();
		return userFound;              
   }
}

