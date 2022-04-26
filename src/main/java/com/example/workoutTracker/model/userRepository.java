package com.example.workoutTracker.model;

import com.example.workoutTracker.model.User;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User, Long> {

    User findByUserName(String userName);

}
