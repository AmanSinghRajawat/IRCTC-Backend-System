package com.irctc.TrainTicketBooking.services;

import com.irctc.TrainTicketBooking.entities.Passenger;
import com.irctc.TrainTicketBooking.entities.Ticket;
import com.irctc.TrainTicketBooking.exceptions.ticketexceptions.TicketNotFoundException;
import com.irctc.TrainTicketBooking.repositories.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private TrainService trainService;

    public void bookTicket(Long trainNumber, String boardingStation, String destinationStation, LocalDateTime date, List<Passenger> passengerList){
//        trainService.bookTicket(trainNumber, boardingStation, destinationStation, date, passengerList);
    }

    public ResponseEntity<Ticket> findTicketByTicketId(Long ticketId){
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(() -> new TicketNotFoundException("ticket not found with ticketId : "+ticketId));
        return ResponseEntity.ok(ticket);
    }

    public ResponseEntity<List<Ticket>> findAll(){
        List<Ticket> allTickets = ticketRepo.findAll();
        return ResponseEntity.ok(allTickets);
    }

}
