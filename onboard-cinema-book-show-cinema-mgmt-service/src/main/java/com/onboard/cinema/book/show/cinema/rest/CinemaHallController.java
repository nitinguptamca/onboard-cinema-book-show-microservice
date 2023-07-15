package com.onboard.cinema.book.show.cinema.rest;

import com.onboard.cinema.book.show.cinema.entity.CinemaHall;
import com.onboard.cinema.book.show.cinema.repository.CinemaHallRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema/hall")
public class CinemaHallController {
    private final CinemaHallRepository cinemaHallRepository;

    public CinemaHallController(CinemaHallRepository cinemaHallRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @PostMapping
    public ResponseEntity<CinemaHall> create(@Valid @RequestBody CinemaHall cinemaHall) {
        CinemaHall cinemaHall1 = cinemaHallRepository.save(cinemaHall);
        return new ResponseEntity(cinemaHall1, HttpStatus.CREATED);
    }
}
