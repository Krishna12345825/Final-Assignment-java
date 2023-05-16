package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Question25Application {

	public static void main(String[] args) {
		SpringApplication.run(Question25Application.class, args);
		UserService userService = SpringApplication
	            .run(Question25Application.class, args)
	            .getBean(UserService.class);

	        userService.createUser("John Doe");
	        userService.getUser("Jane Smith");
	        userService.deleteUser("Alice");
	}

}
