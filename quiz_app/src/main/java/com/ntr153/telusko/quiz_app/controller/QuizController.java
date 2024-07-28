package com.ntr153.telusko.quiz_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ntr153.telusko.quiz_app.model.QuestionWrapper;
import com.ntr153.telusko.quiz_app.model.Quiz;
import com.ntr153.telusko.quiz_app.model.QuizSubmission;
import com.ntr153.telusko.quiz_app.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;
    
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numOfQues, @RequestParam String title) {
        return quizService.createQuiz(category, numOfQues, title);
    }

    @GetMapping("allQuizes")
    public ResponseEntity<List<Quiz>> getAllQuizes() {
        return quizService.getAllQuizes();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id) {
        return quizService.getQuestionById(id);
    }

    @GetMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable(name = "id") int quizId, @RequestBody List<QuizSubmission> quizSubmissions) {
        return quizService.getResult(quizId, quizSubmissions);
    }

}
