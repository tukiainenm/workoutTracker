package com.example.workoutTracker;

import com.example.workoutTracker.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class userRepositoryTests {

    @Autowired
    private userRepository uRepository;


    //Test to create a new user
    @Test
    public void createNewUser() {
        User user = new User("user4", "password", "user");
        uRepository.save(user);
        assertThat(user.getUserName()).isEqualTo("user4");
    }

    //Test to delete a user
    @Test
    public void deleteUser() {
        User user = new User("user5", "password", "user");
        uRepository.save(user);
        uRepository.delete(user);
        assertThat(uRepository.findByUserName("user5")).isNull();
    }
}