package com.example.SpringThreeTier.repository;

import com.example.SpringThreeTier.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUsers(List<User> users){
        String sqlInsert = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";

        jdbcTemplate.batchUpdate(sqlInsert, users, users.size(), (ps, user) -> {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
        });
    }

    public void updateUser(List<User> users){
        String sqlUpdate = "Update users set email = ? where id = ?";

        jdbcTemplate.batchUpdate(sqlUpdate, users, users.size(), (ps, user) -> {
           ps.setInt(2, user.getId());
           ps.setString(1, user.getEmail());
        });
    }


}
