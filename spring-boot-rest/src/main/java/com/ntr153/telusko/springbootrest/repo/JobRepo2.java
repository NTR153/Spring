package com.ntr153.telusko.springbootrest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntr153.telusko.springbootrest.model.JobPost;

// Note: JobRepo.txt was being used for in-app database (list based)

public interface JobRepo2 extends JpaRepository<JobPost, Integer>{

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDescription);

}