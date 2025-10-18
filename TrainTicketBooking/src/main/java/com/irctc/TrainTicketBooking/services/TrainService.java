package com.irctc.TrainTicketBooking.services;

import com.irctc.TrainTicketBooking.entities.Passenger;
import com.irctc.TrainTicketBooking.entities.Train;
import com.irctc.TrainTicketBooking.enums.RunningDays;
import com.irctc.TrainTicketBooking.exceptions.trainexceptions.TrainNotFoundException;
import com.irctc.TrainTicketBooking.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public ResponseEntity<Train> addTrain(Train train){
        trainRepository.save(train);
        return new ResponseEntity<>(train, HttpStatus.CREATED);
    }


    public ResponseEntity<List<Train>> findAllTrains(){
        List<Train> allTrains = trainRepository.findAll();
        if (allTrains.isEmpty()) throw new TrainNotFoundException("No Train Found Database.");
        return ResponseEntity.ok(allTrains);
    }

    public ResponseEntity<Train> findTrainByTrainName(String trainName) {
        Train trainByTrainName = trainRepository.findByTrainName(trainName);
        if (trainByTrainName == null) throw new TrainNotFoundException("No train found with train name : "+ trainName);
        return ResponseEntity.ok(trainByTrainName);
    }

    public ResponseEntity<Train> findTrainByTrainNumber(Long trainNumber){
        Train trainByTrainNumber = trainRepository.findByTrainNumber(trainNumber);
        if(trainByTrainNumber == null) throw new TrainNotFoundException("No train found with train number : "+ trainNumber);
        return ResponseEntity.ok(trainByTrainNumber);
    }

    private ResponseEntity<List<Train>> findTrainByTrainType(Enum trainType) {
        List<Train> trainsByTrainType = trainRepository.findByTrainType(trainType);
        if(trainsByTrainType == null) throw new TrainNotFoundException("No train found of train type : "+ trainType);
        return ResponseEntity.ok(trainsByTrainType);
    }


}
