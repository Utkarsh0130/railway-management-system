package com.example.onlineRailwaySystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role;




    // Manually add getter for password
    public String getPassword() {
        return this.password;
    }

    // Manually add setter for password (if needed)
    public void setPassword(String password) {
        this.password = password;
    }
}
