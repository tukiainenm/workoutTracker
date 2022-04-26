package com.example.workoutTracker.model;

import com.example.workoutTracker.model.Exercise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface exerciseRepository extends CrudRepository<Exercise, Long> {
    List<Exercise> findByName(String name);
}
