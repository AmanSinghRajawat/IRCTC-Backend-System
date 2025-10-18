package com.irctc.TrainTicketBooking.services;

import com.irctc.TrainTicketBooking.entities.Coach;
import com.irctc.TrainTicketBooking.entities.Passenger;
import com.irctc.TrainTicketBooking.entities.Ticket;
import com.irctc.TrainTicketBooking.entities.Train;
import com.irctc.TrainTicketBooking.enums.BookingStatus;
import com.irctc.TrainTicketBooking.enums.RunningDays;
import com.irctc.TrainTicketBooking.repositories.CoachRepo;
import com.irctc.TrainTicketBooking.repositories.PassengerRepo;
import com.irctc.TrainTicketBooking.repositories.TicketRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CoachService {

    @Autowired
    private CoachRepo coachRepo;

    @Autowired
    private PassengerRepo passengerRepo;

    @Autowired
    private TrainService trainService;

    @Autowired
    private TicketRepo ticketRepo;

    public ResponseEntity<Coach> addCoach(Coach coach){
        coachRepo.save(coach);
        return new ResponseEntity<>(coach, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Coach>> findAllCoaches(){
        List<Coach> allCoaches = coachRepo.findAll();
        if(allCoaches.isEmpty()) throw new RuntimeException("No Coaches found in database!");
        return ResponseEntity.ok(allCoaches);
    }

    @Transactional
    public void bookTicket(Long trainNumber, String boardingStation, String destinationStation, LocalDateTime date, List<Passenger> passengers){
//        List<Coach> coaches = coachRepo.findByTrainId(trainNumber);

        Train trainById = trainService.findTrainByTrainNumber(trainNumber).getBody();

        RunningDays runningDays = RunningDays.valueOf(date.getDayOfWeek().name());

        if((trainById.getRunningDays()).contains(runningDays)) {
            System.out.println("Train running on : "+runningDays);
            Ticket ticket = new Ticket();

            for (Passenger passenger :  new ArrayList<>(passengers)) {
                List<Coach> coaches = coachRepo.availableSeats(trainById.getTrainId(), passenger.getCoachType());
                boolean isTicketAvailable = true;
                for (Coach coach : coaches) {
                    Integer availableSeats = coach.getAvailableSeats();
                    if (isTicketAvailable && availableSeats > 0) {

                        // Calculating Total Fare
                        BigDecimal totalFare = BigDecimal.valueOf(coach.getFixedCharges()
                                + coach.getSuperfastCharges()
                                + coach.getReservationCharges()
                                + coach.getRatePerKM()
                                + coach.getSuperfastCharges());

                        // setting Ticket totalFare
                        ticket.setTotalFare(totalFare);
                        ticket.setBookingStatus(BookingStatus.BOOKED);

                        // Generating seat number
                        String coachNumber = coach.getCoachNumber();
                        String seatNumber = coachNumber + "-" + coach.getNextAvailableSeat();
                        coach.setNextAvailableSeat(coach.getNextAvailableSeat() + 1);
                        coach.setAvailableSeats(availableSeats - 1);
                        //                    coach.setBookingStatus(BookingStatus.CONFIRMED);
                        passenger.setBookingStatus(BookingStatus.CONFIRMED);
                        passenger.setSeatNumber(seatNumber);
                        passenger.setCoach(coach);
                        passengerRepo.save(passenger);
                        isTicketAvailable = false;
                        System.out.println("Hi " + passenger.getName() + ", You Booked the Ticket Successfully.");
                    } else {   // Waiting List  -- when writing cancellation logic, will update this waiting list again
                        List<Passenger> waitingList = coach.getWaitingList();
                        if(waitingList.isEmpty()){
                            waitingList = new ArrayList<>();
//                            waitingList.add(passenger);
                        }
                        waitingList.add(passenger);
                        coach.setWaitingList(waitingList);
                        passenger.setBookingStatus(BookingStatus.WAITING_LIST);
                        System.out.println("Hi " + passenger.getName() + ", Your Waiting list number is : " + coach.getWaitingList().size() + ". Thank you!");
                    }

                    // setting up ticket fields
                    ticket.setJourneyDate(date);
                    ticket.setBookingDate(LocalDateTime.now());
                    ticket.setBoardingStation(boardingStation);
                    ticket.setDestinationStation(destinationStation);
                    ticket.setPassengers(passengers);
                    ticket.setTrain(trainById);
                    ticketRepo.save(ticket);
                    if (!isTicketAvailable) break;
                }
                if (coaches == null || coaches.isEmpty()) {
                    throw new RuntimeException("No Coach available in train : " + trainById.getTrainName());
                }
            }
        }else{
            throw new RuntimeException("No train available on : "+date+", day : "+date.getDayOfWeek()+"!");
        }
        ResponseEntity.ok("Success..");
    }
}
