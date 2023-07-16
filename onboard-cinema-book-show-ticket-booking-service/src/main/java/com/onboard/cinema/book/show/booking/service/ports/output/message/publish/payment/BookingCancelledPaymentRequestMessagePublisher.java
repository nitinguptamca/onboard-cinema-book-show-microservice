package com.onboard.cinema.book.show.booking.service.ports.output.message.publish.payment;

import com.onboard.cinema.book.show.booking.domain.event.BookingCancelledEvent;
import com.onboard.cinema.book.show.common.event.publisher.DomainEventPublisher;

public interface BookingCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<BookingCancelledEvent> {
}
