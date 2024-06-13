package com.ntr153.telusko.jobapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ntr153.telusko.jobapp.model.JobPost;
import com.ntr153.telusko.jobapp.service.JobService;

@Controller
public class JobController {

	@Autowired
	private JobService service;

	@GetMapping({ "/", "/home" })
	public String home() {
		return "home";
	}

	@GetMapping("/addjob")
	public String addJob(Model model) {
		model.addAttribute("jobPost", new JobPost());
		return "addjob";
	}

	// controller method for getting all job posts
	@GetMapping("/viewalljobs")
	public String viewJobs(Model model) {
		List<JobPost> jobPosts = service.returnAllJobPosts();
		model.addAttribute("jobPosts", jobPosts);
		return "viewalljobs";
	}

	@PostMapping("/handleForm")
	public String handleAddJobForm(@ModelAttribute("jobPost") JobPost jobPost, Model model) {
		model.addAttribute("jobPost", jobPost);
		service.addJobPost(jobPost);
		return "success";

	}

}