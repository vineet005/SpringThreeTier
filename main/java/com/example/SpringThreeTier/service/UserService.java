package com.example.SpringThreeTier.service;

import com.example.SpringThreeTier.model.User;
import com.example.SpringThreeTier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends UserRepository{
    @Autowired
    private UserRepository userRepository;

    public void addUsers(List<User> users){
        userRepository.addUsers(users);
    }

    @Override
    public void updateUser(List<User> users) {
        userRepository.updateUser(users);
    }
}
