package com.onboard.cinema.book.show.cinema.rest;

import com.onboard.cinema.book.show.cinema.entity.ShowSeat;
import com.onboard.cinema.book.show.cinema.repository.ShowSeatRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show/seat")
public class ShowSeatController {
    private final ShowSeatRepository showSeatRepository;

    public ShowSeatController(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }

    @PostMapping
    public ResponseEntity<ShowSeat> create(@Valid @RequestBody ShowSeat showSeat) {
        ShowSeat showSeat1 = showSeatRepository.save(showSeat);
        return new ResponseEntity<ShowSeat>(showSeat1, HttpStatus.CREATED);
    }
}
