package com.example.onlineRailwaySystem.controllers;

import com.example.onlineRailwaySystem.models.Train;
import com.example.onlineRailwaySystem.models.User;
import com.example.onlineRailwaySystem.service.TrainService;
import com.example.onlineRailwaySystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trains")
@CrossOrigin(origins = "http://localhost:5173")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @Autowired
    private UserService userService;

    // Only ADMIN can add a train
    @PostMapping("/add")
    public ResponseEntity<?> addTrain(@RequestParam Long userId, @RequestBody Train train) {
        ResponseEntity<User> userResponse = userService.getUserById(userId);

        if (userResponse.getStatusCode() == HttpStatus.OK) {
            User user = userResponse.getBody();
            // Check if user is an ADMIN (you might need to implement this logic)

                Train savedTrain = trainService.addTrain(train); // Use the method from TrainService
                return ResponseEntity.status(HttpStatus.CREATED).body(savedTrain);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Train>> getAllTrains() {
        List<Train> trains = trainService.getAllTrains();
        return ResponseEntity.ok(trains);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable Long id) {
        Optional<Train> train = trainService.getTrainById(id);
        return train.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Train> updateTrain(@PathVariable Long id, @RequestBody Train train) {
        train.setId(id);  // Ensure that the ID in the URL is used
        Train updatedTrain = trainService.updateTrain(train);
        return updatedTrain != null ? ResponseEntity.ok(updatedTrain) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrain(@PathVariable Long id) {
        trainService.deleteTrain(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
