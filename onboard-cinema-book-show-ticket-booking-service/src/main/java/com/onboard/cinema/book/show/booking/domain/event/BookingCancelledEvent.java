package com.onboard.cinema.book.show.booking.domain.event;

import com.onboard.cinema.book.show.booking.domain.entiry.Booking;
import com.onboard.cinema.book.show.common.event.publisher.DomainEventPublisher;
import java.time.ZonedDateTime;

public class BookingCancelledEvent extends BookingEvent{

    private final DomainEventPublisher<BookingCancelledEvent> bookingCancelledEventDomainEventPublisher;

    public BookingCancelledEvent(
            Booking booking,
            ZonedDateTime createdAt,
            DomainEventPublisher<BookingCancelledEvent> bookingCancelledEventDomainEventPublisher) {
        super(booking ,createdAt);
        this.bookingCancelledEventDomainEventPublisher = bookingCancelledEventDomainEventPublisher;
    }

    @Override
    public void fire() {

    }
}
