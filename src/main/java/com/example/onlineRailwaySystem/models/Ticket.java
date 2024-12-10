package com.example.onlineRailwaySystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference // Add this annotation
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;  // Many tickets can be for one train

    private String numberOfSeats;
    private String allocatedSeats; // Store seat numbers

    @Enumerated(EnumType.STRING)
    private TicketStatus status;  // Enum for "BOOKED", "PENDING", "REJECTED"
}
