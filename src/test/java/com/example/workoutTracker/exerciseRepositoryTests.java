package com.example.workoutTracker;

import com.example.workoutTracker.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class exerciseRepositoryTests {

    @Autowired
    private exerciseRepository exerciseRepository;


    //Test to see if the exercise is found by name
    @Test
    public void findByNameShouldReturnExercise() {
        exerciseRepository.save(new Exercise("test exercise", "3 x 6"));
        List<Exercise> exercises = exerciseRepository.findByName("test exercise");
        assertThat(exercises).hasSize(1);
        assertThat(exercises.get(0).getName()).isEqualTo("test exercise");
    }
     //Test to create a new exercise
    @Test
    public void createNewExercise() {
        Exercise exercise = new Exercise("Squat", "3 x 3");
        exerciseRepository.save(exercise);
        assertThat(exercise.getId()).isNotNull();
    }

    //Test to delete an exercise
    @Test
    public void deleteExercise() {
        Exercise exercise = new Exercise("Squat", "3 x 3");
        exerciseRepository.save(exercise);
        exerciseRepository.delete(exercise);
        assertThat(exerciseRepository.findByName("Squat")).isEmpty();
    }

}
