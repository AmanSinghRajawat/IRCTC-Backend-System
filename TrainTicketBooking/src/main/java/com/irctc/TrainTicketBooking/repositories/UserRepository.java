package com.irctc.TrainTicketBooking.repositories;

import com.irctc.TrainTicketBooking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByUsername(String username);
}
