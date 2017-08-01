package com.example.demo.controller;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "Hello");
        userService.addUser();
        return "welcome";
    }

}
