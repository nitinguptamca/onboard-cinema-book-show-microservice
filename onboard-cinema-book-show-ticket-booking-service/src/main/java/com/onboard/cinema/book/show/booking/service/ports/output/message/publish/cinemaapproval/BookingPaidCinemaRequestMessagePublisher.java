package com.onboard.cinema.book.show.booking.service.ports.output.message.publish.cinemaapproval;

import com.onboard.cinema.book.show.booking.domain.event.BookingPaidEvent;
import com.onboard.cinema.book.show.common.event.publisher.DomainEventPublisher;

public interface BookingPaidCinemaRequestMessagePublisher extends DomainEventPublisher<BookingPaidEvent> {
}
