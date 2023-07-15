package com.onboard.cinema.book.show.cinema.repository;

import com.onboard.cinema.book.show.cinema.entity.Show;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, UUID> {
}
