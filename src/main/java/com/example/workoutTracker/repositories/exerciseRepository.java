package com.example.workoutTracker.repositories;

import com.example.workoutTracker.entities.Exercise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface exerciseRepository extends CrudRepository<Exercise, Long> {
    List<Exercise> findByName(String name);
}
