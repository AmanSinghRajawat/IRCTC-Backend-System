package com.irctc.TrainTicketBooking.exceptions;

import com.irctc.TrainTicketBooking.exceptions.stationexceptions.StationNotFoundException;
import com.irctc.TrainTicketBooking.exceptions.ticketexceptions.TicketNotFoundException;
import com.irctc.TrainTicketBooking.exceptions.trainexceptions.TrainNotFoundException;
import com.irctc.TrainTicketBooking.exceptions.usersexceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handelUserNotFoundException(UserNotFoundException exception){
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TrainNotFoundException.class)
    public ResponseEntity<ErrorResponse> handelTrainNotFoundException(TrainNotFoundException exception){
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(StationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handelStationNotFoundException(StationNotFoundException exception){
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<ErrorResponse> handelTicketNotFoundException(TicketNotFoundException exception){
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}
