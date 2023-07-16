package com.onboard.cinema.book.show.booking.service.ports.input.service;

import com.onboard.cinema.book.show.booking.service.domain.dto.create.CreateBookingCommand;
import com.onboard.cinema.book.show.booking.service.domain.dto.create.CreateBookingResponse;
import com.onboard.cinema.book.show.booking.service.domain.dto.track.TrackBookingQuery;
import com.onboard.cinema.book.show.booking.service.domain.dto.track.TrackBookingResponse;
import jakarta.validation.Valid;

public interface BookingApplicationService {
    CreateBookingResponse createOrder(@Valid CreateBookingCommand createBookingCommand);
    TrackBookingResponse trackBooking(@Valid TrackBookingQuery trackBookingQuery);
}
