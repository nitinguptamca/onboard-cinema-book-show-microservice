package com.onboard.cinema.book.show.booking.domain;

import com.onboard.cinema.book.show.booking.domain.entiry.Booking;
import com.onboard.cinema.book.show.booking.domain.entiry.CinemaHall;
import com.onboard.cinema.book.show.booking.domain.event.BookingCancelledEvent;
import com.onboard.cinema.book.show.booking.domain.event.BookingCreatedEvent;
import com.onboard.cinema.book.show.booking.domain.event.BookingPaidEvent;
import com.onboard.cinema.book.show.common.event.publisher.DomainEventPublisher;
import java.util.List;

public interface BookingDomainService {
    BookingCreatedEvent validateAndInitiateBooking(Booking booking,
                                                   CinemaHall cinemaHall,
                                                   DomainEventPublisher<BookingCreatedEvent> bookingCreatedEventDomainEventPublisher);
    BookingPaidEvent payOrder(Booking booking, DomainEventPublisher<BookingPaidEvent> bookingPaidEventDomainEventPublisher);
    void approveOrder(Booking booking);
    BookingCancelledEvent cancelOrderPayment(Booking booking, List<String> failureMessages,
                                             DomainEventPublisher<BookingCancelledEvent> bookingCancelledEventDomainEventPublisher);
    void cancelOrder(Booking booking, List<String> failureMessages);
}
