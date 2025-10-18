package com.irctc.TrainTicketBooking.services;

import com.irctc.TrainTicketBooking.entities.Route;
import com.irctc.TrainTicketBooking.entities.RouteStop;
import com.irctc.TrainTicketBooking.repositories.RouteRepo;
import com.irctc.TrainTicketBooking.repositories.RouteStopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RouteStopService {

    @Autowired
    private RouteStopRepo routeStopRepo;

    @Autowired
    private RouteRepo routeRepo;

    public ResponseEntity<RouteStop> addRouteStop(RouteStop routeStop){
        routeStopRepo.save(routeStop);
        return new ResponseEntity<>(routeStop, HttpStatus.CREATED);
    }

    public ResponseEntity<List<RouteStop>> findAllRouteStops(){
        List<RouteStop> allRouteStops = routeStopRepo.findAll();
        if(allRouteStops.isEmpty()) return null;
        return ResponseEntity.ok(allRouteStops);
    }

}
