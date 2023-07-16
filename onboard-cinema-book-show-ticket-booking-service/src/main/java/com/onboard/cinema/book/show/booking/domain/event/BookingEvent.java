package com.onboard.cinema.book.show.booking.domain.event;

import com.onboard.cinema.book.show.booking.domain.entiry.Booking;
import com.onboard.cinema.book.show.common.event.DomainEvent;
import java.time.ZonedDateTime;


public abstract class BookingEvent implements DomainEvent<Booking> {
    private final Booking booking;
    private final ZonedDateTime createdAt;

    protected BookingEvent(Booking booking, ZonedDateTime createdAt) {
        this.booking = booking;
        this.createdAt = createdAt;
    }

    public Booking getBooking() {
        return booking;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
