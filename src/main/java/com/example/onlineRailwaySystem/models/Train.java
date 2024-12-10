package com.example.onlineRailwaySystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trainName;
    private int trainNumber;
    private String source;
    private String destination;
    private double fare;
    private int seatAvailability;


}
