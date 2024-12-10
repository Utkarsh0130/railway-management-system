package com.example.onlineRailwaySystem.repositories;

import com.example.onlineRailwaySystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    // Find user by email
    Optional<User> findByEmail(String email);

    // Change the method to return Optional<User>
    Optional<User> findByUsernameAndPassword(String username, String password);

    // Find all users by role
    List<User> findByRole(String role);
}
