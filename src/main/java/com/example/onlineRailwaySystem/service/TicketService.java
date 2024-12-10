package com.example.onlineRailwaySystem.service;

import com.example.onlineRailwaySystem.models.Ticket;
import com.example.onlineRailwaySystem.models.TicketStatus;
import com.example.onlineRailwaySystem.models.Train;
import com.example.onlineRailwaySystem.models.User;
import com.example.onlineRailwaySystem.repositories.TicketRepository;
import com.example.onlineRailwaySystem.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TrainRepository trainRepository;
    private static final String[] PREFIXES = {"A", "B", "C"};
    private static final Random RANDOM = new Random();
    // Book a new ticket
    public Ticket bookTicket(User user, Long trainId, String numberOfSeats) {
        Optional<Train> train = trainRepository.findById(trainId);
        if (train.isPresent()) {
            Ticket ticket = new Ticket();
            ticket.setUser(user);
            ticket.setTrain(train.get());
            ticket.setNumberOfSeats(numberOfSeats);
            ticket.setStatus(TicketStatus.PENDING); // Set initial status
            return ticketRepository.save(ticket); // Save the new ticket
        } else {
            throw new RuntimeException("Train not found"); // Handle train not found
        }
    }

    // Update ticket status
    public Ticket updateTicketStatus(Long ticketId, TicketStatus status) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setStatus(status);

        if (status == TicketStatus.BOOKED) {
            Train train = ticket.getTrain();
            int availableSeats = train.getSeatAvailability();
            int seatsToBook = Integer.parseInt(ticket.getNumberOfSeats());

            if (seatsToBook <= availableSeats) {
                train.setSeatAvailability(availableSeats - seatsToBook); // Update available seats in the train
                trainRepository.save(train);

                // Generate seat numbers based on remaining seat availability
                String seatNumbers = generateIncrementalSeats(train, seatsToBook);
                ticket.setAllocatedSeats(seatNumbers); // Update the ticket with allocated seat numbers
            } else {
                throw new RuntimeException("Not enough seats available");
            }
        }

        return ticketRepository.save(ticket);
    }


    private String generateIncrementalSeats(Train train, int seatsToBook) {
        int availableSeats = train.getSeatAvailability(); // Get available seats

        StringBuilder seatNumbers = new StringBuilder();
        // Calculate the starting seat number based on current availability
        int startSeatNumber = 100 - availableSeats + 1; // Adjust based on actual total seats

        for (int i = startSeatNumber; i < startSeatNumber + seatsToBook; i++) {
            // Randomly select a prefix from A, B, C
            String prefix = PREFIXES[RANDOM.nextInt(PREFIXES.length)];
            seatNumbers.append(prefix).append(i).append(","); // Append prefix and seat number
        }
        return seatNumbers.substring(0, seatNumbers.length() - 1); // Remove the trailing comma
    }

    // Get all tickets for a user
    public List<Ticket> getTicketsByUser(User user) {
        return ticketRepository.findByUser(user); // Fetch tickets for the user
    }

    // Get tickets by status
    public List<Ticket> getTicketsByStatus(TicketStatus status) {
        return ticketRepository.findByStatus(status); // Fetch tickets by status
    }

    // Get all tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll(); // Fetch all tickets
    }
}
