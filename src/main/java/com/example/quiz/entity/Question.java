package com.example.quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a question entity in the quiz application.
 */
@Entity
@Getter
@Setter
@Table(name = "question")
public class Question {

    /**
     * Unique identifier for the question.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The text of the question.
     */
    private String text;

    /**
     * The options for the question. This can be a JSON string or a delimited list for simplicity.
     */
    private String options;

    /**
     * The correct answer for the question.
     */
    private String correctAnswer;
}

