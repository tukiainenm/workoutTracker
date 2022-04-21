package com.example.workoutTracker.repositories;

import com.example.workoutTracker.entities.Workout;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface workoutRepository extends CrudRepository<Workout, Long> {
    List<Workout> findByName(String name);
}
