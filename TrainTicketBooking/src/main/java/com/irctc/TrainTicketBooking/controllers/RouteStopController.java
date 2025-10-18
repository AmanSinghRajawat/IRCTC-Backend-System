package com.irctc.TrainTicketBooking.controllers;

import com.irctc.TrainTicketBooking.dtos.RouteStopDTO;
import com.irctc.TrainTicketBooking.entities.RouteStop;
import com.irctc.TrainTicketBooking.services.RouteStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stops")
public class RouteStopController {

    @Autowired
    private RouteStopService routeStopService;

    @GetMapping("/health")
    public String testing(){
        return "Hello RouteStops!";
    }
    @PostMapping("/add")
    public ResponseEntity<RouteStop> addRouteStop(@RequestBody RouteStop routeStop){
        return routeStopService.addRouteStop(routeStop);
    }

    @GetMapping({"","/getAll"})
    public ResponseEntity<List<RouteStop>> getAllRouteStops(){
        return routeStopService.findAllRouteStops();
    }

}
