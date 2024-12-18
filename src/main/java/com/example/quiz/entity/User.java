package com.example.quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a user in the quiz application.
 *
 * This class is annotated with {@link Entity} to indicate that it is a JPA entity.
 * It uses {@link Getter} and {@link Setter} from Lombok to automatically generate getter and setter methods.
 * The table name for this entity is specified using {@link Table} annotation.
 */
@Entity
@Getter
@Setter
@Table(name = "username")
public class User {

    /**
     * The unique identifier for the user.
     * This field is annotated with {@link Id} to indicate that it is the primary key.
     * It is also annotated with {@link GeneratedValue} to specify that the value should be generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the user.
     */
    private String name;
}

