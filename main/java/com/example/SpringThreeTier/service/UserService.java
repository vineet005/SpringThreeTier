package com.example.SpringThreeTier.service;

import com.example.SpringThreeTier.model.User;
import com.example.SpringThreeTier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<User> getUsersByEmailDomain(String domain){
        return userRepository.getUsersByEmailDomain(domain);
    }

    public int countUsers(){
        return (int)userRepository.count();
    }

}
