package com.ntr153.telusko.quiz_service.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuizSubmission {

    private int questionId;
    private String selectedAnswer;

}
