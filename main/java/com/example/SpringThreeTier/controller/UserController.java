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

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PutMapping("/update")
    public User updateMail(@RequestBody User user){
        return userService.updateMail(user.getId(), user.getEmail());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        System.out.println("User Deleted!");
    }

}
