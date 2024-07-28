package com.ntr153.telusko.quiz_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntr153.telusko.quiz_app.model.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {

    
}