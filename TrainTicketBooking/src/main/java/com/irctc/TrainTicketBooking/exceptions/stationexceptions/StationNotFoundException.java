package com.irctc.TrainTicketBooking.exceptions.stationexceptions;

public class StationNotFoundException extends RuntimeException{

    public StationNotFoundException(String msg){
        super(msg);
    }

    public StationNotFoundException(){}
}
