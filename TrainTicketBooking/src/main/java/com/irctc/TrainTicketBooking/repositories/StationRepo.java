package com.irctc.TrainTicketBooking.repositories;

import com.irctc.TrainTicketBooking.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepo extends JpaRepository<Station, Long> {



}
