package com.irctc.TrainTicketBooking.repositories;

import com.irctc.TrainTicketBooking.entities.Coach;
import com.irctc.TrainTicketBooking.enums.CoachType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoachRepo extends JpaRepository<Coach, Long> {

    @Query("SELECT c FROM Coach c WHERE c.train.trainId = :trainId")
    List<Coach> findByTrainId(@Param("trainId") Long trainId);

    @Query("select c from Coach c where c.train.trainId = :trainId and c.coachType = :coachType")
    List<Coach> availableSeats(@Param("trainId") Long trainId, @Param("coachType") CoachType coachType);
}
