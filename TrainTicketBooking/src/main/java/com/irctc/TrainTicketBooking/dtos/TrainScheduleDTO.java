package com.irctc.TrainTicketBooking.dtos;

import com.irctc.TrainTicketBooking.enums.CoachType;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class TrainScheduleDTO {

        private String trainNumber;
        private String trainName;
        private String fromStation;
        private String toStation;
        private LocalTime departureTime;
        private LocalTime arrivalTime;
        private Duration duration;
        private Map<CoachType, Double> fares;
        private List<LocalTime> intermediateStops;

}
