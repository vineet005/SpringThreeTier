package com.example.SpringThreeTier;

import com.example.SpringThreeTier.model.User;
import com.example.SpringThreeTier.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringThreeTierApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {

		SpringApplication.run(SpringThreeTierApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(5, "John Doe", "john.doe@example.com");
		userRepository.addUserWithExceptionHandling(user1);

		// Attempt to add a user with the same email to trigger the exception
		User user2 = new User(9, "Jane Doe", "john.doe@example.com");
		userRepository.addUserWithExceptionHandling(user2);
	}
}
