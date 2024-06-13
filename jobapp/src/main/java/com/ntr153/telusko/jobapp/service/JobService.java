package com.ntr153.telusko.jobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntr153.telusko.jobapp.repo.JobRepo;
import com.ntr153.telusko.jobapp.model.JobPost;

@Service
public class JobService {
	@Autowired
	public JobRepo repo;

	// method to return all JobPosts
	public List<JobPost> returnAllJobPosts() {
		return repo.returnAllJobPosts();

	}

	// ***************************************************************************

	// method to add a jobPost
	public void addJobPost(JobPost jobPost) {
		repo.addJobPost(jobPost);

	}

}
