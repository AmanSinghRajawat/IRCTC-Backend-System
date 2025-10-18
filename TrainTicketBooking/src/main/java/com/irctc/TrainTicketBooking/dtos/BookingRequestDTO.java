package com.irctc.TrainTicketBooking.dtos;

import com.irctc.TrainTicketBooking.entities.Passenger;

import java.time.LocalDate;
import java.util.List;

public class BookingRequestDTO {

    private Long trainNumber;
    private LocalDate date;
    private String boardingStation;
    private String destinationStation;
    private List<Passenger> passengerList;

}
