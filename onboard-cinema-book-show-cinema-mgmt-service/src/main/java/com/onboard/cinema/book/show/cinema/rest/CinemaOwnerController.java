package com.onboard.cinema.book.show.cinema.rest;

import com.onboard.cinema.book.show.cinema.entity.CinemaOwner;
import com.onboard.cinema.book.show.cinema.repository.CinemaOwnerRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinemaOwner")
public class CinemaOwnerController {
    private final CinemaOwnerRepository cinemaOwnerRepository;


    public CinemaOwnerController(CinemaOwnerRepository cinemaOwnerRepository) {
        this.cinemaOwnerRepository = cinemaOwnerRepository;
    }

    @PostMapping
    public ResponseEntity<CinemaOwner> create(@Valid @RequestBody CinemaOwner cinemaOwner) {
        CinemaOwner cinemaOwner1 = cinemaOwnerRepository.save(cinemaOwner);
        return new ResponseEntity(cinemaOwner1, HttpStatus.CREATED);
    }


}
