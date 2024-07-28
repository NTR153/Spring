package com.ntr153.telusko.quiz_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntr153.telusko.quiz_app.model.Question;
import com.ntr153.telusko.quiz_app.service.QuestionService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService service;
    
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return service.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return service.getQuestionsByCategory(category);
    }

    @GetMapping("get/{id}")
    public Question getQuestionsById(@PathVariable int id) {
        return service.getQuestionsById(id);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return service.addQuestion(question);
    }

    @DeleteMapping("deleteQuestion/{questionId}")
    public String deleteQuestion(@PathVariable int questionId) {
        service.deleteQuestion(questionId);
        return "Success";
    }
    
    @GetMapping("getDuplicates")
    public Map<String, List<Question>> getDuplicates() {
        return service.getDuplicates();
    }

}