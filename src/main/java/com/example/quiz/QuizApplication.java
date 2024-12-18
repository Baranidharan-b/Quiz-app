package com.example.quiz;

import com.example.quiz.Repository.QuestionRepository;
import com.example.quiz.Repository.UserRepository;
import com.example.quiz.entity.Question;
import com.example.quiz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class QuizApplication implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Manually execute the data.sql script
		jdbcTemplate.execute("INSERT INTO username (id, name) VALUES (1, 'John Doe')");
		jdbcTemplate.execute("INSERT INTO question (id, text, options, correct_answer) VALUES (1, 'What is 2+2?', '4,3,5,2', '4')");
		jdbcTemplate.execute("INSERT INTO question (id, text, options, correct_answer) VALUES (2, 'Capital of France?', 'Paris,London,Berlin,Madrid', 'Paris')");
		jdbcTemplate.execute("INSERT INTO question (id, text, options, correct_answer) VALUES (3, 'Sun rises in?', 'East,West,North,South', 'East')");
	}

}
