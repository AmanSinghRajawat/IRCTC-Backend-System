package com.irctc.TrainTicketBooking.controllers;

import com.irctc.TrainTicketBooking.entities.Coach;
import com.irctc.TrainTicketBooking.services.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @GetMapping("/health")
    public String testing(){
        return "Hello Coaches!";
    }

    @PostMapping("/add")
    public ResponseEntity<Coach> addCoach(@RequestBody Coach coach){
        return coachService.addCoach(coach);
    }

    @GetMapping({"","/getAll"})
    public ResponseEntity<List<Coach>> getAllCoaches(){
        return coachService.findAllCoaches();
    }

//    @GetMapping("/seats")
//    public void totalSeatsInEachCoachType(){
//        coachService.totalSeatsInEachCoachType(1L);
//    }

}
