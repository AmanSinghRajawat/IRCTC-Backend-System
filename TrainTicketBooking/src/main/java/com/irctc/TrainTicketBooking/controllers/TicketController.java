package com.irctc.TrainTicketBooking.controllers;

import com.irctc.TrainTicketBooking.entities.Ticket;
import com.irctc.TrainTicketBooking.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/health")
    public String health(){
        return "Ticket Controller is working fine!";
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> findTicket(@PathVariable Long ticketId){
        Ticket ticketByTicketId = ticketService.findTicketByTicketId(ticketId).getBody();
        return ResponseEntity.ok(ticketByTicketId);
    }


    @GetMapping({"/allTickets","/",""})
    public ResponseEntity<List<Ticket>> allTickets(){
        ResponseEntity<List<Ticket>> allTickets = ticketService.findAll();
        return ResponseEntity.ok(allTickets).getBody();
    }


}
