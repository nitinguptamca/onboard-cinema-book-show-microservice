package com.onboard.cinema.book.show.booking.domain.event;

import com.onboard.cinema.book.show.booking.domain.entiry.Booking;
import com.onboard.cinema.book.show.common.event.publisher.DomainEventPublisher;
import java.time.ZonedDateTime;

public class BookingCreatedEvent extends BookingEvent{

    private final DomainEventPublisher<BookingCreatedEvent> bookingCreatedEventDomainEventPublisher;

    public BookingCreatedEvent(
            Booking booking,
            ZonedDateTime createdAt,
            DomainEventPublisher<BookingCreatedEvent> bookingCreatedEventDomainEventPublisher) {
        super(booking ,createdAt);
        this.bookingCreatedEventDomainEventPublisher = bookingCreatedEventDomainEventPublisher;
    }
    @Override
    public void fire() {
        bookingCreatedEventDomainEventPublisher.publish(this);
    }
}
