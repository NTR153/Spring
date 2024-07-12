package com.ntr153.telusko.springbootrest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntr153.telusko.springbootrest.model.JobPost;
// import com.ntr153.telusko.springbootrest.repo.JobRepo1;
import com.ntr153.telusko.springbootrest.repo.JobRepo2;

@Service
public class JobService {

	// @Autowired
	// public JobRepo1 repo1;

	// public List<JobPost> getAllJobs() {
	// 	return repo1.getAllJobs();
	// }

	// public void addJob(JobPost jobPost) {
	// 	repo1.addJob(jobPost);
	// }

	// public JobPost getJob(int postId) {
	// 	return repo1.getJob(postId);
	// }

	// public void updateJob(JobPost jobPost) {
	// 	repo1.updateJob(jobPost);
	// }

	// public void deleteJob(int postId) {
	// 	repo1.deleteJob(postId);
	// }

	/* JobRepo2 */

	@Autowired
	public JobRepo2 repo2;

	public List<JobPost> getAllJobs() {
		return repo2.findAll();

	}

	public void addJob(JobPost jobPost) {
		repo2.save(jobPost);
	}

	public JobPost getJob(int postId) {
		return repo2.findById(postId).orElse(null);
	}

	public void updateJob(JobPost jobPost) {
		repo2.save(jobPost);
	}

	public void deleteJob(int postId) {
		repo2.deleteById(postId);
	}

    public void load() {

		List<JobPost> jobs = new ArrayList<>();

		jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
				Arrays.asList("Core Java", "J2EE", "Spring Boot", "Hibernate")));

		// Frontend Developer Job Post
		jobs.add(new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
				3, Arrays.asList("HTML", "CSS", "JavaScript", "React")));

		// Data Scientist Job Post
		jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
				Arrays.asList("Python", "Machine Learning", "Data Analysis")));

		// Network Engineer Job Post
		jobs.add(new JobPost(4, "Network Engineer",
				"Design and implement computer networks for efficient data communication", 5,
				Arrays.asList("Networking", "Cisco", "Routing", "Switching")));

		// Mobile App Developer Job Post
		jobs.add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
				Arrays.asList("iOS Development", "Android Development", "Mobile App")));

		repo2.saveAll(jobs);	
    }

	public List<JobPost> searchByKeyword(String keyword) {
		return repo2.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
	}
	
}
