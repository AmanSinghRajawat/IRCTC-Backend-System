package com.irctc.TrainTicketBooking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.irctc.TrainTicketBooking.enums.CoachType;
import com.irctc.TrainTicketBooking.enums.RunningDays;
import com.irctc.TrainTicketBooking.enums.TrainType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainId;

    @Column(unique = true, nullable = false)
    private Long trainNumber;
    @Column(nullable = false, unique = true)
    private String trainName;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TrainType trainType;  // Passenger, Superfast, Express

    @ElementCollection
    @CollectionTable(
            name = "train_running_days",
            joinColumns = @JoinColumn(name = "train_id")
    )
    @Column(name = "running_day")
    @Enumerated(EnumType.STRING)
    private Set<RunningDays> runningDays;

//    private List<List<Integer>> seats;


    @OneToMany(mappedBy = "train", fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnoreProperties({"routes"}) // Prevent serialization of routes when serializing train
    private List<Route> routes;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference // *Imp* This allows serialization of stops when serializing route
    private List<Coach> coaches = new ArrayList<>();

    /*
    @ElementCollection
    @CollectionTable(name = "seat_pricing",
            joinColumns = @JoinColumn(name = "train_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "coach_type")
    @Column(name = "price")
    private Map<CoachType, Double> seatPricing;

     */
}
