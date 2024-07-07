package com.ntr153.telusko.spring_data_rest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntr153.telusko.spring_data_rest.model.JobPost;


// Note: JobRepo.txt was being used for in-app database (list based)

public interface JobRepo extends JpaRepository<JobPost, Integer>{

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDescription);

}