package com.irctc.TrainTicketBooking.exceptions.trainexceptions;

public class TrainNotFoundException extends RuntimeException{

    public TrainNotFoundException(String msg){
        super(msg);
    }

    public TrainNotFoundException(){}
}
