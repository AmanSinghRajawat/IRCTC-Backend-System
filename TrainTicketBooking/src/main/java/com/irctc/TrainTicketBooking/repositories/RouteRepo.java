package com.irctc.TrainTicketBooking.repositories;

import com.irctc.TrainTicketBooking.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepo extends JpaRepository<Route, Long> {
}
