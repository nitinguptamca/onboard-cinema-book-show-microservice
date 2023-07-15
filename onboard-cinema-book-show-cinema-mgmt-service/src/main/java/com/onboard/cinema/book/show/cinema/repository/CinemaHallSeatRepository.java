package com.onboard.cinema.book.show.cinema.repository;

import com.onboard.cinema.book.show.cinema.entity.CinemaHallSeat;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaHallSeatRepository extends JpaRepository<CinemaHallSeat, UUID> {
}
