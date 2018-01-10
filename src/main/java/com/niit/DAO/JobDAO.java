package com.niit.DAO;

import java.util.List;

import com.niit.model.Jobs;

public interface JobDAO {
public boolean addJob(Jobs job);
	
	public boolean updateJob(Jobs job);
	public boolean deleteJob(Jobs job);
	
	public Jobs getJob(int jobId);
	
	public List<Jobs> getAlljobs();
	
	public boolean approveJob(Jobs job);
	
	public boolean rejectJob(Jobs job);
	
}
