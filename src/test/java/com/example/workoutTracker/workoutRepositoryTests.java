package com.example.workoutTracker;


import com.example.workoutTracker.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;
import java.util.List;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class workoutRepositoryTests {

    @Autowired
    private workoutRepository workoutRepository;

    //Test to see if the workoutRepository can save a workout
    @Test
    public void createNewWorkout(){
        Workout workout = new Workout();
        workout.setName("test");
        workoutRepository.save(workout);
        assertThat(workout.getId()).isNotNull();
    }

    //Test to delete a workout
    @Test
    public void deleteWorkout() {
        Workout workout = new Workout();
        workout.setName("test");
        workoutRepository.save(workout);
        workoutRepository.delete(workout);
        assertThat(workoutRepository.findById(workout.getId())).isEmpty();
    }

}
