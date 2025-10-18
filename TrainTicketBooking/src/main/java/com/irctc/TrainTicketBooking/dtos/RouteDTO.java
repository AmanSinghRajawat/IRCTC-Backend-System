package com.irctc.TrainTicketBooking.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class RouteDTO {

    private String routeName;
    private boolean isActive;
    private LocalDate validFrom;
    private LocalDate validTo;
    private List<RouteStopDTO> stops;
    // ...

}
