package com.example.workoutTracker.repositories;

import com.example.workoutTracker.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface categoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String name);
}
