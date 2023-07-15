package com.onboard.cinema.book.show.cinema.rest;

import com.onboard.cinema.book.show.cinema.entity.CinemaHallSeat;
import com.onboard.cinema.book.show.cinema.repository.CinemaHallSeatRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema/hall/seat")
public class CinemaHallSeatController {

    private final CinemaHallSeatRepository cinemaHallSeatRepository;

    public CinemaHallSeatController(CinemaHallSeatRepository cinemaHallSeatRepository) {
        this.cinemaHallSeatRepository = cinemaHallSeatRepository;
    }


    @PostMapping
    public ResponseEntity<CinemaHallSeat> create(@Valid @RequestBody CinemaHallSeat cinemaHallSeat){
        CinemaHallSeat cinemaHallSeat1= cinemaHallSeatRepository.save(cinemaHallSeat);
        return new ResponseEntity<>(cinemaHallSeat1 , HttpStatus.CREATED);
    }

}
