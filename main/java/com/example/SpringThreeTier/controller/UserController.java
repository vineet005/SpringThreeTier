package com.example.SpringThreeTier.controller;

import com.example.SpringThreeTier.model.User;
import com.example.SpringThreeTier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController extends UserService{
    @Autowired
    private UserService userService;

    @PostMapping("/batch")
    public void addUsers(@RequestBody List<User> users){
        userService.addUsers(users);
    }

    @Override
    @PutMapping("/batch")
    public void updateUser(@RequestBody List<User> users) {
        userService.updateUser(users);
    }
}
