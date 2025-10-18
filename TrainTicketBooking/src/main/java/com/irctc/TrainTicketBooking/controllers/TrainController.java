package com.irctc.TrainTicketBooking.controllers;

import com.irctc.TrainTicketBooking.entities.Train;
import com.irctc.TrainTicketBooking.enums.TrainType;
import com.irctc.TrainTicketBooking.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping("/health")
    public String testing(){
        return "Hello Trains!";
    }

    @PostMapping("/add")
    public ResponseEntity<Train> addTrain(@RequestBody Train train){
        return trainService.addTrain(train);
    }

    @GetMapping({"","/getAll"})
    public ResponseEntity<List<Train>> getAllTrains(){
        return trainService.findAllTrains();
    }

    @GetMapping("/name/{trainName}")
    public ResponseEntity<Train> getTrainByTrainName(@PathVariable String trainName){
        return trainService.findTrainByTrainName(trainName);
    }

    @GetMapping("/number/{trainNumber}")
    public ResponseEntity<Train> getTrainByTrainNumber(@PathVariable Long trainNumber){
        return trainService.findTrainByTrainNumber(trainNumber);
    }

    @GetMapping("/type/{trainType}")
    public ResponseEntity<Train> getTrainByTrainType(@PathVariable String trainType){
        Enum<TrainType> train = TrainType.valueOf(trainType.toUpperCase());
        return trainService.findTrainByTrainName(trainType);
    }

}
