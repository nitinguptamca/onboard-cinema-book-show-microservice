package com.onboard.cinema.book.show.booking.service.ports.input.service.impl;

import com.onboard.cinema.book.show.booking.service.domain.dto.create.CreateBookingCommand;
import com.onboard.cinema.book.show.booking.service.domain.dto.create.CreateBookingResponse;
import com.onboard.cinema.book.show.booking.service.domain.dto.track.TrackBookingQuery;
import com.onboard.cinema.book.show.booking.service.domain.dto.track.TrackBookingResponse;
import com.onboard.cinema.book.show.booking.service.ports.input.service.BookingApplicationService;
import org.springframework.stereotype.Service;

@Service
public class BookingApplicationServiceImpl implements BookingApplicationService {
    @Override
    public CreateBookingResponse createOrder(CreateBookingCommand createBookingCommand) {
        CreateBookingResponse createBookingResponse = null;
        return createBookingResponse;
    }

    @Override
    public TrackBookingResponse trackBooking(TrackBookingQuery trackBookingQuery) {
        TrackBookingResponse trackBookingResponse=null;
        return trackBookingResponse;
    }
}
