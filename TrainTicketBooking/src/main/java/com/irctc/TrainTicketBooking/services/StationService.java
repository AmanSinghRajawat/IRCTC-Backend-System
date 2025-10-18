package com.irctc.TrainTicketBooking.services;

import com.irctc.TrainTicketBooking.entities.Station;
import com.irctc.TrainTicketBooking.exceptions.stationexceptions.StationNotFoundException;
import com.irctc.TrainTicketBooking.repositories.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StationService {

    @Autowired
    private StationRepo stationRepo;

    public ResponseEntity<Station> addStation(Station station){
        stationRepo.save(station);
        return new ResponseEntity<>(station, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Station>> findAllStations(){
        List<Station> allStations = stationRepo.findAll();
        if(allStations.isEmpty()) throw new StationNotFoundException("No Station found in database!");
        return ResponseEntity.ok(allStations);
    }

}
