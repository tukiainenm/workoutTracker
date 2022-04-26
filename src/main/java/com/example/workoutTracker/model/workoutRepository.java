package com.example.workoutTracker.model;

import com.example.workoutTracker.model.Workout;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface workoutRepository extends CrudRepository<Workout, Long> {
    List<Workout> findByName(String name);
}
