package com.irctc.TrainTicketBooking.services;


import com.irctc.TrainTicketBooking.entities.Passenger;
import com.irctc.TrainTicketBooking.entities.Ticket;
import com.irctc.TrainTicketBooking.entities.User;
import com.irctc.TrainTicketBooking.exceptions.usersexceptions.UserNotFoundException;
import com.irctc.TrainTicketBooking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CoachService coachService;

    public ResponseEntity<User> addUser(User user){
        user.setPasswordInText(user.getPassword());
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userRepository.findAll();
        if(allUsers.isEmpty()) throw new UserNotFoundException("No User Found in Database.");
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    public ResponseEntity<User> getUserByEmail(String email){
        User user = userRepository.findByEmail(email);
        if(user == null) throw new UserNotFoundException("User not found with email : "+email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> getUserByUsername(String username){
        User userByUsername = userRepository.findByUsername(username);
        if(userByUsername == null) throw new UserNotFoundException("User not found with username : "+username);
        return ResponseEntity.ok(userByUsername);
    }

    public void bookTicket(Long trainNumber, String boardingStation, String destinationStation, LocalDateTime date, List<Passenger> passengers) {
        coachService.bookTicket(trainNumber, boardingStation, destinationStation, date, passengers);
    }
}
