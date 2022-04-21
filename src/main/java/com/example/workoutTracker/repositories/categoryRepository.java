package com.example.workoutTracker.repositories;

import com.example.workoutTracker.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface categoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByName(String name);
}
