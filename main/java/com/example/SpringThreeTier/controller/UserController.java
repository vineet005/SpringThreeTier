package com.example.SpringThreeTier.controller;

import com.example.SpringThreeTier.model.User;
import com.example.SpringThreeTier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.adduser(user);
    }
}
