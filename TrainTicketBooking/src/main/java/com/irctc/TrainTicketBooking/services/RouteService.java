package com.irctc.TrainTicketBooking.services;

import com.irctc.TrainTicketBooking.entities.Route;
import com.irctc.TrainTicketBooking.repositories.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepo routeRepo;

    public ResponseEntity<Route> addRoute(Route route){
        routeRepo.save(route);
        return new ResponseEntity<>(route, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Route>> findAllRoutes(){
        List<Route> allRoutes = routeRepo.findAll();
        if(allRoutes.isEmpty()) return null;
        return ResponseEntity.ok(allRoutes);
    }

    public ResponseEntity<Route> findById(Long routeId){
        Route routeById = routeRepo.findById(routeId).orElseThrow(() -> new RuntimeException("Route not found routeId : "+routeId) );
        return ResponseEntity.ok(routeById);
    }

}
