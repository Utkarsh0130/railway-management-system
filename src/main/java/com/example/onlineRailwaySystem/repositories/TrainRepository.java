package com.example.onlineRailwaySystem.repositories;

import com.example.onlineRailwaySystem.models.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

    // Find train by train number (unique identifier)
    Train findByTrainNumber(int trainNumber);
}
