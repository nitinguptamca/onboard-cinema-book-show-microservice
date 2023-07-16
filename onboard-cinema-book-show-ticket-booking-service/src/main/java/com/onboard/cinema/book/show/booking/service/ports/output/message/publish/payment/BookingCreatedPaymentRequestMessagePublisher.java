package com.onboard.cinema.book.show.booking.service.ports.output.message.publish.payment;

import com.onboard.cinema.book.show.booking.domain.event.BookingCreatedEvent;
import com.onboard.cinema.book.show.common.event.publisher.DomainEventPublisher;

public interface BookingCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<BookingCreatedEvent> {
}
