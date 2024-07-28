package com.ntr153.telusko.quiz_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "question_seq")
    @SequenceGenerator(name = "question_seq", sequenceName = "QUESTION_SEQ", allocationSize = 1)        // This is for Oracle SQL
    private int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String category;
    private String difficultyLevel;
    
}