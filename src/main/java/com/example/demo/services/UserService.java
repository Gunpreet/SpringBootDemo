package com.example.demo.services;


import org.springframework.stereotype.Component;

@Component
public class UserService {

    public void addUser() {
        System.out.println("Adding User");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
