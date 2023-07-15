package com.onboard.cinema.book.show.cinema.repository;

import com.onboard.cinema.book.show.cinema.entity.ShowSeat;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, UUID> {
}
