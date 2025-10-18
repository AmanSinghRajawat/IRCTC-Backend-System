package com.irctc.TrainTicketBooking.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
public class BookingRequest {
    private Long trainNumber;
    private String from;
    private String to;
    private LocalDate date;
    private List<Passenger> passengers;

}
