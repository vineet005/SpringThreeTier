package com.example.SpringThreeTier.service;

import com.example.SpringThreeTier.model.User;
import com.example.SpringThreeTier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User adduser(User user){
        return userRepository.save(user);
    }
}
