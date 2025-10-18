package com.irctc.TrainTicketBooking.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    @JsonBackReference // *Imp* This prevents serialization of the route when serializing RouteStop
    private Train train;

    @Column(nullable = false)
    private String routeName;  // e.g., "Delhi-Mumbai Central Route"

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER, orphanRemoval = true)
    @OrderBy("sequenceNumber ASC")
    @JsonManagedReference // *Imp* This allows serialization of stops when serializing route
    private List<RouteStop> stops = new ArrayList<>();

//    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
//    private List<TrainSchedule> schedules = new ArrayList<>();

//    @Column(nullable = false)
    private boolean isActive = true;

//    @Column(nullable = false)
    private LocalDate validFrom;

//    @Column(nullable = false)
    private LocalDate validTo;

    // Helper methods to manage bidirectional relationship
    public void addStop(RouteStop stop) {
        stops.add(stop);
        stop.setRoute(this);
    }

    public void removeStop(RouteStop stop) {
        stops.remove(stop);
        stop.setRoute(null);
    }

}
