package com.irctc.TrainTicketBooking.exceptions.usersexceptions;


public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String msg){
        super(msg);
    }

    public UserNotFoundException(){}
}
