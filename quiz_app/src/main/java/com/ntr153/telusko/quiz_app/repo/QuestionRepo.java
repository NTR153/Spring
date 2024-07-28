package com.ntr153.telusko.quiz_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ntr153.telusko.quiz_app.model.Question;

import java.util.List;


@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
    
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY DBMS_RANDOM.VALUE FETCH FIRST :numOfQues ROWS ONLY", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numOfQues);
    
}