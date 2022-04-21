package com.example.workoutTracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.workoutTracker.entities.*;
import com.example.workoutTracker.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkoutTrackerApplication {
	private static final Logger log = LoggerFactory.getLogger(WorkoutTrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WorkoutTrackerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(exerciseRepository eRepository, categoryRepository cRepository) {
		return (args) -> {

			// Create Categories
			log.info("Creating some categories");
			cRepository.save(new Category("Legs"));
			cRepository.save(new Category("Chest"));
			cRepository.save(new Category("Whole body"));

			// Create Exercises
			log.info("Creating some exercises");
			eRepository.save(new Exercise("Squat", cRepository.findByName("Legs").get(0)));
			eRepository.save(new Exercise("Bench press", cRepository.findByName("Chest").get(0)));
			eRepository.save(new Exercise("Deadlift", cRepository.findByName("Whole body").get(0)));


		};
	}
}


