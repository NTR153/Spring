package com.ntr153.telusko.quiz_service.service;

import java.util.List;

import com.ntr153.telusko.quiz_service.feign.QuizInterface;
import com.ntr153.telusko.quiz_service.model.QuestionWrapper;
import com.ntr153.telusko.quiz_service.model.Quiz;
import com.ntr153.telusko.quiz_service.model.QuizSubmission;
import com.ntr153.telusko.quiz_service.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    
    @Autowired
    private QuizRepo quizRepo;

//    @Autowired
//    private QuestionRepo questionRepo;

    @Autowired
    private QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numOfQues, String title) {

        List<Integer> questionIds = quizInterface.getQuestionIdsForQuiz(category, numOfQues).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionIds);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Quiz>> getAllQuizes() {
        return new ResponseEntity<>(quizRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionById(int id) {

        Quiz quiz = quizRepo.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsByIds(questionIds);

        return questions;
    }

    public ResponseEntity<Integer> getResult(int quizId, List<QuizSubmission> quizSubmissions) {
        return quizInterface.getScore(quizSubmissions);
    }

}
