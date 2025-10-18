package com.irctc.TrainTicketBooking.repositories;

import com.irctc.TrainTicketBooking.entities.Train;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {


    Train findByTrainName(String trainName);

    Train findByTrainNumber(Long trainNumber);

    List<Train> findByTrainType(Enum trainType);
}
