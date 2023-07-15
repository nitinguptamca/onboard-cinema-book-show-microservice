package com.onboard.cinema.book.show.cinema.repository;

import com.onboard.cinema.book.show.cinema.entity.CinemaOwner;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaOwnerRepository extends JpaRepository<CinemaOwner, UUID> {
}
