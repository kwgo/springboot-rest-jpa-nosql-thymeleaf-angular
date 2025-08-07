package com.kwgo.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kwgo.quiz.logger.Log;

/**
 * 
 * Springboot start class
 *
 */
@SpringBootApplication
@EnableJpaRepositories
public class QuizApplication {
	/**
	 * Main method to start project
	 */
	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
		Log.getLogger().debug("Quiz application is ready");
	}

}
