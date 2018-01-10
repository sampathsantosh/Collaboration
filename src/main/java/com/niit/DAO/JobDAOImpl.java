package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Jobs;


@Repository
public class JobDAOImpl implements JobDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	JobDAO jobDAO;
	
	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean addJob(Jobs job) {
		try
		{
		sessionFactory.getCurrentSession().save(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	
	}
@Transactional
	public boolean updateJob(Jobs job) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}
@Transactional
	public boolean deleteJob(Jobs job) {
		try
		{
		sessionFactory.getCurrentSession().delete(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}
@Transactional
	public Jobs getJob(int jobId) {
		Session session=sessionFactory.openSession();
		Jobs job=(Jobs)session.get(Jobs.class, jobId);
		session.close();
		return job;
	}
@Transactional
	public List<Jobs> getAlljobs() {
Session session=sessionFactory.openSession();
		
		List<Jobs> jobList=(List<Jobs>)session.createQuery("from Jobs").list();
		session.close();
		return jobList;
	}
@Transactional
	public boolean approveJob(Jobs job) {
		try{
			job.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}	
		}
@Transactional
	public boolean rejectJob(Jobs job) {
		try{
			job.setStatus("N");
			sessionFactory.getCurrentSession().update(job);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}	
		
	}

}