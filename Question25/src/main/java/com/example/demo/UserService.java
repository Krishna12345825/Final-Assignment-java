package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void createUser(String username) {
        System.out.println("Creating user: " + username);
    }

    public String getUser(String username) {
        System.out.println("Getting user: " + username);
        return "User: " + username;
    }

    public void deleteUser(String username) {
        System.out.println("Deleting user: " + username);
    }
}

