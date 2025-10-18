package com.irctc.TrainTicketBooking.exceptions.ticketexceptions;

public class TicketNotFoundException extends RuntimeException{

    public TicketNotFoundException(String msg){
        super(msg);
    }

    public TicketNotFoundException(){}
}
