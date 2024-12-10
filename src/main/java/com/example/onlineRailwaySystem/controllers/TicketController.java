package com.example.onlineRailwaySystem.controllers;

import com.example.onlineRailwaySystem.models.Ticket;
import com.example.onlineRailwaySystem.models.TicketStatus;
import com.example.onlineRailwaySystem.models.User;
import com.example.onlineRailwaySystem.service.TicketService;
import com.example.onlineRailwaySystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:5173")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    // Book a ticket (requires user ID and train ID)
    @PostMapping("/book")
    public ResponseEntity<Ticket> bookTicket(@RequestParam Long userId, @RequestParam Long trainId, @RequestParam String numberOfSeats) {
        User user = userService.getUserById(userId).getBody();
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        try {
            Ticket ticket = ticketService.bookTicket(user, trainId, numberOfSeats);
            return ResponseEntity.ok(ticket);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);  // Handle error (e.g., train not found)
        }
    }

    // Update ticket status
    @PutMapping("/{id}/status")
    public ResponseEntity<Ticket> updateTicketStatus(@PathVariable Long id, @RequestParam TicketStatus status) {
        try {
            Ticket updatedTicket = ticketService.updateTicketStatus(id, status);
            return ResponseEntity.ok(updatedTicket);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all tickets for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ticket>> getTicketsByUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId).getBody();
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        List<Ticket> tickets = ticketService.getTicketsByUser(user);
        return ResponseEntity.ok(tickets);
    }

    // Get tickets by status
    @GetMapping("/status")
    public ResponseEntity<List<Ticket>> getTicketsByStatus(@RequestParam TicketStatus status) {
        List<Ticket> tickets = ticketService.getTicketsByStatus(status);
        return ResponseEntity.ok(tickets);
    }
    // Get all tickets (admin route)
    @GetMapping("/admin/all")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }
}
