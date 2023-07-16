package com.onboard.cinema.book.show.booking;

import com.onboard.cinema.book.show.booking.domain.BookingDomainService;
import com.onboard.cinema.book.show.booking.domain.entiry.Booking;
import com.onboard.cinema.book.show.booking.domain.entiry.CinemaHall;
import com.onboard.cinema.book.show.booking.domain.entiry.Movie;
import com.onboard.cinema.book.show.booking.domain.entiry.Show;
import com.onboard.cinema.book.show.booking.domain.event.BookingCancelledEvent;
import com.onboard.cinema.book.show.booking.domain.event.BookingCreatedEvent;
import com.onboard.cinema.book.show.booking.domain.event.BookingPaidEvent;
import com.onboard.cinema.book.show.booking.domain.exception.BookingDomainException;
import com.onboard.cinema.book.show.common.event.publisher.DomainEventPublisher;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class BookingDomainServiceImpl implements BookingDomainService {
    private static final String UTC ="UTC";
    @Override
    public BookingCreatedEvent validateAndInitiateBooking(Booking booking,
                                                          CinemaHall cinemaHall,
                                                          DomainEventPublisher<BookingCreatedEvent> bookingCreatedEventDomainEventPublisher) {
        validateCinemaHall(cinemaHall);
        setBookShowInformation(booking,cinemaHall);
        booking.validateBooking();
        booking.initializeBooking();
        log.info("Booking with id: {} is initiated", booking.getId().getValue());
        return new BookingCreatedEvent(booking, ZonedDateTime.now(ZoneId.of("UTC")), bookingCreatedEventDomainEventPublisher);

    }

    @Override
    public BookingPaidEvent payOrder(Booking booking, DomainEventPublisher<BookingPaidEvent> bookingPaidEventDomainEventPublisher) {
        booking.pay();
        log.info("Booking with id: {} is Paid", booking.getId().getValue());
        return new BookingPaidEvent(booking, ZonedDateTime.now(ZoneId.of(UTC)), bookingPaidEventDomainEventPublisher);
    }

    @Override
    public void approveOrder(Booking booking) {
        booking.approve();
        log.info("Booking with id: {} is APPROVED", booking.getId().getValue());
    }

    @Override
    public BookingCancelledEvent cancelOrderPayment(Booking booking, List<String> failureMessages, DomainEventPublisher<BookingCancelledEvent> bookingCancelledEventDomainEventPublisher) {
        booking.initCancel(failureMessages);
        log.info("Booking payment is cancelling for booking id: {}", booking.getId().getValue());
        return new BookingCancelledEvent(booking,ZonedDateTime.now(ZoneId.of(UTC)), bookingCancelledEventDomainEventPublisher);
    }

    @Override
    public void cancelOrder(Booking booking, List<String> failureMessages) {
        booking.cancel(failureMessages);
        log.info("Booking payment is cancelled for booking id: {}", booking.getId().getValue());
    }

    private void validateCinemaHall(CinemaHall cinemaHall){
        if(! cinemaHall.isActive())
            throw new BookingDomainException("CinemaHall with id " + cinemaHall.getId().getValue() +
            "is currently not in service");
    }

    private void setBookShowInformation(Booking booking ,CinemaHall cinemaHall){
        booking.getBookShowList().forEach(
               bookshow -> {
                   for (Show show : cinemaHall.getShows()) {
                       Show currentShow = bookshow.getShow();
                       if(currentShow.equals(show)){
                           currentShow.updateWithConfirmedTitleAndPrice(
                                   show.getCinemaHallId(),
                                   show.getMovieId(),
                                   show.getStartTime(),
                                   show.getEndTime(),
                                   show.getShowDate(),
                                   show.getShowId(),
                                   show.getPrice()
                           );
                       }
                   }
               }
        );
    }
}
