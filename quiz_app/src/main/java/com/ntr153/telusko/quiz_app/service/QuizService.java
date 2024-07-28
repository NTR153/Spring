package com.ntr153.telusko.quiz_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ntr153.telusko.quiz_app.model.Question;
import com.ntr153.telusko.quiz_app.model.QuestionWrapper;
import com.ntr153.telusko.quiz_app.model.Quiz;
import com.ntr153.telusko.quiz_app.model.QuizSubmission;
import com.ntr153.telusko.quiz_app.repo.QuestionRepo;
import com.ntr153.telusko.quiz_app.repo.QuizRepo;

@Service
public class QuizService {
    
    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numOfQues, String title) {
        
        try {
            List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, numOfQues);
            
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);

            quizRepo.save(quiz);

            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Quiz>> getAllQuizes() {
        return new ResponseEntity<>(quizRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionById(int id) {

        Optional<Quiz> quiz = quizRepo.findById(id);

        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for (Question q: questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(
                q.getId(),
                q.getQuestionTitle(), 
                q.getOption1(), 
                q.getOption2(), 
                q.getOption3(), 
                q.getOption4()
                );

            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getResult(int quizId, List<QuizSubmission> quizSubmissions) {
        
        Quiz quiz = quizRepo.findById(quizId).get();
        List<Question> questions = quiz.getQuestions();

        int rightAnswers = 0;
        int i = 0;

        for (QuizSubmission qs : quizSubmissions) {
            if (qs.getSelectedAnswer().equals(questions.get(i).getRightAnswer()))
                rightAnswers++;
            i++;
        }

        return new ResponseEntity<>(rightAnswers, HttpStatus.OK);

    }

}
