package com.irctc.TrainTicketBooking.dtos;


import lombok.Data;

import java.time.LocalTime;

// DTO's is used for custom api response, or when you do not want to expose real entity.
@Data
public class RouteStopDTO {

        private Long stationId;
        private int sequenceNumber;
        private LocalTime arrivalTime;
        private LocalTime departureTime;
        private int haltDuration;
        private int distanceFromOrigin;

}
