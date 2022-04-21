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
    public CommandLineRunner demo(exerciseRepository eRepository) {
        return (args) -> {
            // Create Exercises
            log.info("Creating some exercises");
            eRepository.save(new Exercise("Squat"));
            eRepository.save(new Exercise("Bench press"));
            eRepository.save(new Exercise("Deadlift"));

            //Example workouts


        };
    }
}


