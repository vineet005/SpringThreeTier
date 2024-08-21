package com.example.SpringThreeTier.repository;

import com.example.SpringThreeTier.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    public UserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUserWithExceptionHandling(User user){
        String sql = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(sql,user.getId(), user.getName(), user.getEmail());
            System.out.println("User Added Successfully!");
        }catch (DuplicateKeyException e){
            System.err.println("Error: A user with this email already exists.");
        }catch (Exception e){
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

}
