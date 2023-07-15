package com.onboard.cinema.book.show.cinema.rest;

import com.onboard.cinema.book.show.cinema.entity.Booking;
import com.onboard.cinema.book.show.cinema.repository.BookingRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @PostMapping
    public ResponseEntity<Booking> create(@Valid @RequestBody Booking booking){
        Booking booking1= bookingRepository.save(booking);
        return new ResponseEntity<>(booking1 , HttpStatus.CREATED);
    }
}
