package com.example.onlineRailwaySystem.repositories;

import com.example.onlineRailwaySystem.models.Ticket;
import com.example.onlineRailwaySystem.models.TicketStatus;
import com.example.onlineRailwaySystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // Find all tickets by user
    List<Ticket> findByUser(User user);

    // Find all tickets by status
    List<Ticket> findByStatus(TicketStatus status);

    // Find all tickets by user and status
    List<Ticket> findByUserAndStatus(User user, TicketStatus status);
}
