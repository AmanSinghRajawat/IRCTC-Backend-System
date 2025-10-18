package com.irctc.TrainTicketBooking.repositories;

import com.irctc.TrainTicketBooking.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {



}
