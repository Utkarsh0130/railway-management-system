package com.example.onlineRailwaySystem.controllers;

import com.example.onlineRailwaySystem.models.User;
import com.example.onlineRailwaySystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
        ResponseEntity<User> responseEntity = userService.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

        return responseEntity; // This will return the user or an UNAUTHORIZED response
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        user.setRole("USER");
        ResponseEntity<User> registeredResponse = userService.registerUser(user);
        return registeredResponse;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserProfile(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUserProfile(user);
    }

    @PutMapping("/{id}/change-password")
    public ResponseEntity<User> changePassword(@PathVariable Long id, @RequestParam String newPassword) {
        return userService.changePassword(id, newPassword);
    }
}
