package com.irctc.TrainTicketBooking.controllers;

import com.irctc.TrainTicketBooking.dtos.RouteDTO;
import com.irctc.TrainTicketBooking.entities.Route;
import com.irctc.TrainTicketBooking.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/health")
    public String testing(){
        return "Hello Route!";
    }

    @PostMapping("/add")
    public ResponseEntity<Route> addRoute(@RequestBody Route route){
        return routeService.addRoute(route);
    }

    @GetMapping({"","/getAll"})
    public ResponseEntity<List<Route>> getAllRoutes(){
        return routeService.findAllRoutes();
    }

}
