package com.ntr153.telusko.question_service.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntr153.telusko.question_service.model.Question;
import com.ntr153.telusko.question_service.model.QuestionWrapper;
import com.ntr153.telusko.question_service.model.QuizSubmission;
import com.ntr153.telusko.question_service.service.QuestionService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    Environment env;
    
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("get/{id}")
    public Question getQuestionsById(@PathVariable int id) {
        return questionService.getQuestionsById(id);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("deleteQuestion/{questionId}")
    public String deleteQuestion(@PathVariable int questionId) {
        questionService.deleteQuestion(questionId);
        return "Success";
    }
    
    @GetMapping("getDuplicates")
    public Map<String, List<Question>> getDuplicates() {
        return questionService.getDuplicates();
    }

    // For MicroServices

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionIdsForQuiz
            (@RequestParam String category, @RequestParam int numOfQues) {    // We will only be returning question Id's
        return questionService.getQuestionsForQuiz(category, numOfQues);
    }
    
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsByIds(@RequestBody List<Integer> questionIds) {

        System.out.println(env.getProperty("local.server.port"));

        return questionService.getQuestionsByIds(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<QuizSubmission> quizSubmissions) {
        return questionService.getScore(quizSubmissions);
    }
    
}