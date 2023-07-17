package com.onboard.cinema.book.show.booking.rest;

import com.onboard.cinema.book.show.booking.service.domain.dto.create.CreateBookingCommand;
import com.onboard.cinema.book.show.booking.service.domain.dto.create.CreateBookingResponse;
import com.onboard.cinema.book.show.booking.service.ports.input.service.BookingApplicationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/book/my/show")
public class BookingController {
    private final BookingApplicationService bookingApplicationService;

    public BookingController(BookingApplicationService bookingApplicationService) {
        this.bookingApplicationService = bookingApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateBookingResponse> create(@Valid @RequestBody CreateBookingCommand createBookingCommand){
        log.info("Creating booking for customer: {} at cinemahall: {}", createBookingCommand.getCustomerId(),
                createBookingCommand.getCinemaHallId());
        CreateBookingResponse createBookingResponse=bookingApplicationService.createOrder(createBookingCommand);
        log.info("booking created with tracking id: {}", createBookingResponse.getBookTrackingId());
        return new ResponseEntity<>(createBookingResponse ,HttpStatus.CREATED);
    }
}
