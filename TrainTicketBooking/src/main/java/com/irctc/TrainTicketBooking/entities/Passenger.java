package com.irctc.TrainTicketBooking.entities;

import com.irctc.TrainTicketBooking.enums.BookingStatus;
import com.irctc.TrainTicketBooking.enums.CoachType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String gender;
    private String idProof; // Aadhaar, Passport

    private String seatNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CoachType coachType;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    // coach details should not be present in passenger's object
    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;
}
