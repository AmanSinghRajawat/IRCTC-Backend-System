package com.irctc.TrainTicketBooking.controllers;

import com.irctc.TrainTicketBooking.entities.Station;
import com.irctc.TrainTicketBooking.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/health")
    public String testing(){
        return "Hello Stations!";
    }

    @PostMapping("/add")
    public ResponseEntity<Station> addStation(@RequestBody Station station){
        return stationService.addStation(station);
    }

    @GetMapping({"","/getAll"})
    public ResponseEntity<List<Station>> getAllStations(){
        return stationService.findAllStations();
    }

}
