package com.ntr153.telusko.quiz_app.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ntr153.telusko.quiz_app.model.Question;
import com.ntr153.telusko.quiz_app.repo.QuestionRepo;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo repo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(repo.findAll().stream()
        .sorted(new QuestionComparator())
        .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return repo.findByCategory(category).stream()
        .sorted(Comparator.comparingInt(Question::getId))
        .collect(Collectors.toList());
    }

    public ResponseEntity<Question> addQuestion(Question question) {
        return new ResponseEntity<>(repo.save(question), HttpStatus.CREATED);
    }

    public void deleteQuestion(int questionId) {
        repo.deleteById(questionId);
    }

    class QuestionComparator implements Comparator<Question> {
        @Override
        public int compare(Question q1, Question q2) {
            return Integer.compare(q1.getId(), q2.getId());
        }
    }

    public Map<String, List<Question>> getDuplicates() {
        return repo.findAll().stream()
        .collect(Collectors.groupingBy(Question::getQuestionTitle)).entrySet().stream()
        .filter(entry -> entry.getValue().size() > 1)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Question getQuestionsById(int id) {
        return repo.findById(id).get();
    }
    
}