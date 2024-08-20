package com.example.SpringThreeTier.controller;

import com.example.SpringThreeTier.model.User;
import com.example.SpringThreeTier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController{
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/by-domain")
    public List<User> getUsersByEmailDomain(@RequestParam String domain){
        return userService.getUsersByEmailDomain(domain);
    }

    @GetMapping("/count")
    public int countUsers(){
        return userService.countUsers();
    }
}
