package com.onboard.cinema.book.show.booking.domain.event;

import com.onboard.cinema.book.show.booking.domain.entiry.Booking;
import com.onboard.cinema.book.show.common.event.publisher.DomainEventPublisher;
import java.time.ZonedDateTime;

public class BookingPaidEvent extends  BookingEvent{
    private final DomainEventPublisher<BookingPaidEvent> bookingPaidEventDomainEventPublisher;

    public BookingPaidEvent(
            Booking booking,
            ZonedDateTime createdAt,
            DomainEventPublisher<BookingPaidEvent> bookingPaidEventDomainEventPublisher) {
        super(booking ,createdAt);
        this.bookingPaidEventDomainEventPublisher = bookingPaidEventDomainEventPublisher;
    }

    @Override
    public void fire() {

    }
}
