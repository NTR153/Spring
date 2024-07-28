package com.ntr153.telusko.quiz_app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Quiz {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "quiz_seq")
    @SequenceGenerator(name = "quiz_seq", sequenceName = "QUIZ_SEQ", allocationSize = 1)
    private int id;
    private String title;
    @ManyToMany
    private List<Question> questions;

}
