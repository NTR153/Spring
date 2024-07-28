package com.ntr153.telusko.question_service.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ntr153.telusko.question_service.model.Question;
import com.ntr153.telusko.question_service.model.QuestionWrapper;
import com.ntr153.telusko.question_service.model.QuizSubmission;
import com.ntr153.telusko.question_service.repo.QuestionRepo;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepo.findAll().stream()
        .sorted(new QuestionComparator())
        .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepo.findByCategory(category).stream()
        .sorted(Comparator.comparingInt(Question::getId))
        .collect(Collectors.toList());
    }

    public ResponseEntity<Question> addQuestion(Question question) {
        return new ResponseEntity<>(questionRepo.save(question), HttpStatus.CREATED);
    }

    public void deleteQuestion(int questionId) {
        questionRepo.deleteById(questionId);
    }

    class QuestionComparator implements Comparator<Question> {
        @Override
        public int compare(Question q1, Question q2) {
            return Integer.compare(q1.getId(), q2.getId());
        }
    }

    public Map<String, List<Question>> getDuplicates() {
        return questionRepo.findAll().stream()
        .collect(Collectors.groupingBy(Question::getQuestionTitle)).entrySet().stream()
        .filter(entry -> entry.getValue().size() > 1)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Question getQuestionsById(int id) {
        return questionRepo.findById(id).get();
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, int numOfQues) {
        return new ResponseEntity<>(questionRepo.findRandomQuestionsByCategory(category, numOfQues), HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsByIds(List<Integer> questionIds) {
        
        List<QuestionWrapper> wrappers = new ArrayList<>();

        for (int id : questionIds) {

            Question q = questionRepo.findById(id).get();

            QuestionWrapper qw = new QuestionWrapper(
                q.getId(), 
                q.getQuestionTitle(), 
                q.getOption1(), 
                q.getOption2(), 
                q.getOption3(), 
                q.getOption4()
                );

            wrappers.add(qw);
        }

        return new ResponseEntity<>(wrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<QuizSubmission> quizSubmissions) {
        
        int rightAnswers = 0;

        for (QuizSubmission qs : quizSubmissions) {
            Question question = questionRepo.findById(qs.getQuestionId()).get();
            
            if (qs.getSelectedAnswer().equals(question.getRightAnswer()))
                rightAnswers++;
        }

        return new ResponseEntity<>(rightAnswers, HttpStatus.OK);
    }
    
}