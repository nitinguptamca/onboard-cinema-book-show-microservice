package com.onboard.cinema.book.show.cinema.repository;

import com.onboard.cinema.book.show.cinema.entity.Booking;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
