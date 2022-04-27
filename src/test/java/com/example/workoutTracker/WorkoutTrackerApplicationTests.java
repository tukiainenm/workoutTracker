package com.example.workoutTracker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.workoutTracker.web.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class WorkoutTrackerApplicationTests {

	@Autowired
	private workoutController workoutController;

	@Autowired
	private userController userController;

	//Testing the workoutController
	@Test
	void contextLoads() throws Exception {
		assertThat(workoutController).isNotNull();
	}

	//Testing the userController
	@Test
	void contextLoads1() throws Exception {
		assertThat(userController).isNotNull();
	}

}
