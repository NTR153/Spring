package com.ntr153.telusko.quiz_service.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Quiz {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "quiz_seq")
    @SequenceGenerator(name = "quiz_seq", sequenceName = "QUIZ_SEQ", allocationSize = 1)
    private int id;
    private String title;
    @ElementCollection
    private List<Integer> questionIds;

}
