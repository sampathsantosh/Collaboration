package com.niit.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ProfilePicture;




@Repository("profilePictureDAO")
public class ProfilePictureDAOImpl implements ProfilePictureDAO {

	@Autowired
	SessionFactory sessionFactory;

	public ProfilePictureDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public ProfilePicture getProfilePicture(String username) {

		Session session = sessionFactory.openSession();
		ProfilePicture profilePicture = (ProfilePicture) session.get(ProfilePicture.class, username);
		session.close();
		return profilePicture;
	}

	@Transactional
	public void saveProfilePicture(ProfilePicture profilePicture) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
		session.close();
		
		
	}

}