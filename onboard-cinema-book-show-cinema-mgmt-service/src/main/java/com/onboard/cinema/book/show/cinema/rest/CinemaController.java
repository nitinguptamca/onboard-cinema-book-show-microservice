package com.onboard.cinema.book.show.cinema.rest;

import com.onboard.cinema.book.show.cinema.entity.Cinema;
import com.onboard.cinema.book.show.cinema.repository.CinemaRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    private final CinemaRepository cinemaRepository;


    public CinemaController(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @PostMapping
    public ResponseEntity<Cinema>  create(@Valid @RequestBody Cinema cinema){
        Cinema cinema1 = cinemaRepository.save(cinema);
        return new ResponseEntity<>(cinema1 , HttpStatus.CREATED);
    }
}
