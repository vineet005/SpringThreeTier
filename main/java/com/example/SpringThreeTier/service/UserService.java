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

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateMail(int id, String email){
        userRepository.findById(id).orElse(null).setEmail(email);
        userRepository.save(userRepository.findById(id).orElse(null));
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

}
