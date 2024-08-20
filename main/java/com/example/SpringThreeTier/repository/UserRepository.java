package com.example.SpringThreeTier.repository;

import com.example.SpringThreeTier.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query("SELECT u FROM User u WHERE u.email LIKE %:domain")
    List<User> getUsersByEmailDomain(@Param("domain") String domain);
}
