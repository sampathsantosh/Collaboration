package com.niit.test;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.DAO.JobDAO;
import com.niit.config.DbConfig;
import com.niit.model.Job;



@ComponentScan("collbackend")
@Ignore
public class JobTest {
static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("collbackend");
		context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
@Ignore
	@Test
	public void addJobTest()
	{
		Job job=new Job();
		job.setJobProfile("software");
		job.setJobDesc("software trainer");
		job.setQualification("btech");
		job.setStatus("N");
		job.setPostDate(new java.util.Date());
		
		assertTrue("Problem in Inserting Job",jobDAO.addJob(job));
	
	}
	@Ignore
	@Test
	public void updateJob()
	{
		Job job=new Job();
		job.setJobId(73);
		job.setJobProfile("software");
		job.setJobDesc("software engineer");
		job.setQualification("btech");
		job.setStatus("N");
		job.setPostDate(new java.util.Date());
		
		assertTrue("Problem in Inserting Job",jobDAO.updateJob(job));
	}
	
@Ignore
	@Test
	public void getJobTest(){
		Job job=(Job)jobDAO.getJob(73);
		
		System.out.println("JobProfile:" + job.getJobProfile());
		System.out.println("Status:" +job.getStatus());
		
		assertNotNull("job not found", job);
	}
	
@Ignore
	@Test
	public void deleteJobTest(){
		Job job=(Job)jobDAO.getJob(73);
		assertTrue("Problem in deletion",jobDAO.deleteJob(job));
	}
@Ignore
	@Test
	public void approveJobTest(){
		Job job=(Job)jobDAO.getJob(77);
		assertTrue("Problem in approving",jobDAO.approveJob(job));
	}
	@Ignore
	@Test
	public void getAllJobTest(){
		List<Job> jobList=(List<Job>)jobDAO.getAlljobs();
		assertNotNull("Job list not found ",jobList.get(0));
		for(Job job:jobList)
		{
			System.out.println("JObID:"+job.getJobId() + "JobProfile:"+job.getJobProfile());
		}
	}
		
	}