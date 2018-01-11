 package com.niit.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.DAO.BlogDAO;
import com.niit.DAO.BlogDAOImpl;
import com.niit.DAO.ForumDAO;
import com.niit.DAO.ForumDAOImpl;
import com.niit.DAO.FriendDAO;
import com.niit.DAO.FriendDAOImpl;
import com.niit.DAO.JobDAO;
import com.niit.DAO.JobDAOImpl;
import com.niit.DAO.ProfilePictureDAO;
import com.niit.DAO.ProfilePictureDAOImpl;
import com.niit.DAO.UserDAO;
import com.niit.DAO.UserDAOImpl;
import com.niit.model.Blog;
import com.niit.model.Forum;
import com.niit.model.Friend;
import com.niit.model.Jobs;
import com.niit.model.ProfilePicture;
import com.niit.model.UsersDetails;




@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
@Component
public class DbConfig {

	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("site");
		dataSource.setPassword("site");

		System.out.println("DataBase is connected.........!");
		return dataSource;
	}

	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.format_sql","true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		return properties;

	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
	
		sessionBuilder.addAnnotatedClasses(Blog.class);
		sessionBuilder.addAnnotatedClasses(Forum.class);
		sessionBuilder.addAnnotatedClasses(UsersDetails.class);
		sessionBuilder.addAnnotatedClasses(Jobs.class);
		sessionBuilder.addAnnotatedClasses(Friend.class);
		sessionBuilder.addAnnotatedClass(ProfilePicture.class);
		sessionBuilder.scanPackages("com.niit");
		System.out.println("Session is crated................!");

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction is created............!");
		return transactionManager;
	}
	
	@Autowired
	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO(SessionFactory sessionFactory)
	{
		System.out.println("Blog DAO object Created");
		return new BlogDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="forumDAO")
	public ForumDAO getForumDAO(SessionFactory sessionFactory)
	{
		System.out.println("Forum DAO object Created");
		return new ForumDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		System.out.println("User DAO object Created");
		return new UserDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="jobDAO")
	public JobDAO getJobDAO(SessionFactory sessionFactory)
	{
		System.out.println("Job DAO object Created");
		return new JobDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="friendDAO")
	public FriendDAO getFriendDAO(SessionFactory sessionFactory)
	{
		System.out.println("Friend DAO object Created");
		return new FriendDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="profilePictureDAO")

	public ProfilePictureDAO getProfilePictureDAO(SessionFactory sessionFactory) {
		System.out.println("ProfilePicture DAO object Created");
		return new ProfilePictureDAOImpl(sessionFactory);
	}
}