package com.irctc.TrainTicketBooking.controllers;

import com.irctc.TrainTicketBooking.entities.Passenger;
import com.irctc.TrainTicketBooking.entities.User;
import com.irctc.TrainTicketBooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public String testing(){
        return "Hello User";
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping({"","/getAll"})
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }


    @PostMapping("/booking/trainNo/{trainNumber}/from/{boardingStation}/to/{destinationStation}/date/{date}")
    public void BookTicket(
            @PathVariable Long trainNumber,
            @PathVariable String boardingStation,
            @PathVariable String destinationStation,
            @PathVariable LocalDateTime date,
            @RequestBody List<Passenger> passengers){
        userService.bookTicket(trainNumber,boardingStation,destinationStation,date, passengers);
    }

}
