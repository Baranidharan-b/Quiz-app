package com.example.quiz.controller;

import com.example.quiz.entity.Question;
import com.example.quiz.entity.QuizSession;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling quiz-related operations.
 */
@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    /**
     * Starts a new quiz session for the given user.
     *
     * @param userId The ID of the user starting the quiz.
     * @return A ResponseEntity containing the started QuizSession if successful,
     * or an error message if an exception occurs.
     */
    @PostMapping("/start/{userId}")
    public ResponseEntity<?> startQuiz(@PathVariable Long userId) {
        try {
            QuizSession quizSession = quizService.startQuiz(userId);
            return ResponseEntity.ok(quizSession);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error starting quiz: " + e.getMessage());
        }
    }

    /**
     * Retrieves a random question for the quiz.
     *
     * @return A ResponseEntity containing the random Question.
     */
    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion() {
        return ResponseEntity.ok(quizService.getRandomQuestion());
    }

    /**
     * Retrieves a random question for the quiz.
     *
     * @return A ResponseEntity containing the random Question.
     */
    @PostMapping("/submit/{sessionId}/{questionId}")
    public ResponseEntity<String> submitAnswer(@PathVariable Long sessionId,
                                               @PathVariable Long questionId,
                                               @RequestParam String answer) {
        quizService.submitAnswer(sessionId, questionId, answer);
        return ResponseEntity.ok("Answer submitted successfully");
    }

    /**
     * Retrieves the summary of a completed quiz session.
     *
     * @param sessionId The ID of the completed quiz session.
     * @return A ResponseEntity containing the QuizSession summary.
     */
    @GetMapping("/summary/{sessionId}")
    public ResponseEntity<QuizSession> getSummary(@PathVariable Long sessionId) {
        return ResponseEntity.ok(quizService.getQuizSummary(sessionId));
    }
}


