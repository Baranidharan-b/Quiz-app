package com.example.quiz.service;


import com.example.quiz.Repository.QuestionRepository;
import com.example.quiz.Repository.QuizSessionRepository;
import com.example.quiz.Repository.UserRepository;
import com.example.quiz.entity.Question;
import com.example.quiz.entity.QuizSession;
import com.example.quiz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * This service class provides methods for managing quiz sessions, including starting a new session,
 * retrieving random questions, submitting answers, and retrieving quiz summary.
 */
@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuizSessionRepository quizSessionRepository;

    /**
     * Starts a new quiz session for the given user.
     *
     * @param userId The ID of the user starting the quiz session.
     * @return The newly created quiz session.
     */
    public QuizSession startQuiz(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        QuizSession session = new QuizSession();
        session.setUser(user);
        session.setTotalQuestions(0);
        session.setCorrectAnswers(0);
        session.setIncorrectAnswers(0);
        QuizSession savedSession = quizSessionRepository.save(session);
        System.out.println("Created Quiz Session: " + savedSession);
        return savedSession;
    }

    /**
     * Retrieves a random question from the available questions.
     *
     * @return A random question.
     */
    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) {
            throw new RuntimeException("No questions available");
        }
        return questions.get(new Random().nextInt(questions.size()));
    }

    /**
     * Submits an answer for a given question in a specific quiz session.
     *
     * @param sessionId The ID of the quiz session.
     * @param questionId The ID of the question being answered.
     * @param answer The submitted answer.
     */
    public void submitAnswer(Long sessionId, Long questionId, String answer) {
        QuizSession session = quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        session.setTotalQuestions(session.getTotalQuestions() + 1);
        if (question.getCorrectAnswer().equals(answer)) {
            session.setCorrectAnswers(session.getCorrectAnswers() + 1);
        } else {
            session.setIncorrectAnswers(session.getIncorrectAnswers() + 1);
        }
        quizSessionRepository.save(session);
    }

    /**
     * Retrieves the quiz summary for a given quiz session.
     *
     * @param sessionId The ID of the quiz session.
     * @return The quiz session summary.
     */
    public QuizSession getQuizSummary(Long sessionId) {
        return quizSessionRepository.findById(sessionId).orElseThrow(() -> new RuntimeException("Session not found"));
    }
}


