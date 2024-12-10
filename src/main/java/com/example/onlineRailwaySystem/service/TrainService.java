package com.example.onlineRailwaySystem.service;

import com.example.onlineRailwaySystem.models.Train;
import com.example.onlineRailwaySystem.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    // Add a new train
    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }

    // Get all trains
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    // Get a train by its ID
    public Optional<Train> getTrainById(Long id) {
        return trainRepository.findById(id);
    }

    // Update train details
    public Train updateTrain(Train train) {
        Optional<Train> existingTrain = trainRepository.findById(train.getId());
        if (existingTrain.isPresent()) {
            Train updatedTrain = existingTrain.get();
            updatedTrain.setFare(train.getFare());
            updatedTrain.setSource(train.getSource());
            updatedTrain.setDestination(train.getDestination());
            updatedTrain.setTrainName(train.getTrainName());
            updatedTrain.setTrainNumber(train.getTrainNumber());
            updatedTrain.setSeatAvailability(train.getSeatAvailability());
            return trainRepository.save(updatedTrain);
        }
        return null; // Handle appropriately, e.g., throwing an exception
    }

    // Delete a train by its ID
    public void deleteTrain(Long id) {
        trainRepository.deleteById(id);
    }
}
