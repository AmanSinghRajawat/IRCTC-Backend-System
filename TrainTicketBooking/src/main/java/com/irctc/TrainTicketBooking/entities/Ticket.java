package com.irctc.TrainTicketBooking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.irctc.TrainTicketBooking.enums.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;  // like PNR

    @ManyToOne(fetch = FetchType.LAZY)  // LAZY to avoid unnecessary joins
    @JoinColumn(name = "train_id")      // Explicit foreign key
    @JsonIgnore
    private Train train;

//    No Need, because passenger contains booking status
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;  // booked, confirm, waiting list, RAC, cancelled

    @Column(precision = 10, scale = 2)
    private BigDecimal totalFare;

    private String boardingStation;

    private String destinationStation;

//    @ElementCollection
//    @CollectionTable(name = "coach_seat_mapping", joinColumns = @JoinColumn(name = "passenger_id"))
//    @MapKeyJoinColumn(name = "coach_id")  // Maps the Coach entity key
//    @Column(name = "seat_number")         // Maps the Integer value
//    private Map<Coach, Integer> seatNumber;  // S4 - 46

    @Column(updatable = false)
    private LocalDateTime bookingDate;

    @NotNull
    private LocalDateTime journeyDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id")  // Owns the relationship
    private List<Passenger> passengers; // multiple passengers

//    @ManyToOne(fetch = FetchType.LAZY)  // LAZY to avoid unnecessary joins
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column(length = 500)
    private String remarks;


}
