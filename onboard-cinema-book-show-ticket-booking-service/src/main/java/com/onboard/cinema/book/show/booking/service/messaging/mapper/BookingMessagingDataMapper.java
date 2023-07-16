package com.onboard.cinema.book.show.booking.service.messaging.mapper;

import com.onboard.cinema.book.show.booking.domain.entiry.Booking;
import com.onboard.cinema.book.show.booking.domain.event.BookingCreatedEvent;
import com.onboard.cinema.book.show.booking.domain.event.BookingPaidEvent;
import com.onboard.cinema.book.show.kafka.booking.avro.model.CinemaApprovalRequestAvroModel;
import com.onboard.cinema.book.show.kafka.booking.avro.model.CinemaBookingStatus;
import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus;
import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class BookingMessagingDataMapper {
    public PaymentRequestAvroModel bookingCreatedEventToPaymentRequestAvroModel(BookingCreatedEvent bookingCreatedEvent){
        Booking booking = bookingCreatedEvent.getBooking();
        return  PaymentRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setCustomerId(booking.getCustomerId().getValue().toString())
                .setBookingId(booking.getId().getValue().toString())
                .setMovieId(booking.getMovie().getId().toString())
                .setShowId(booking.getShow().getId().toString())
                .setCinemaId(booking.getCinemaId().getValue().toString())
                .setCinemaHallId(booking.getCinemaHallId().getValue().toString())
                .setPrice(booking.getPrice().getAmount())
                .setCreatedAt(bookingCreatedEvent.getCreatedAt().toInstant())
                .setPaymentBookingStatus(PaymentBookingStatus.PENDING)
                .build();
    }

    public PaymentRequestAvroModel bookingCancelledEventToPaymentRequestAvroModel(BookingCreatedEvent bookingCreatedEvent){
        Booking booking = bookingCreatedEvent.getBooking();
        return  PaymentRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setCustomerId(booking.getCustomerId().getValue().toString())
                .setBookingId(booking.getId().getValue().toString())
                .setMovieId(booking.getMovie().getId().toString())
                .setShowId(booking.getShow().getId().toString())
                .setCinemaId(booking.getCinemaId().getValue().toString())
                .setCinemaHallId(booking.getCinemaHallId().getValue().toString())
                .setPrice(booking.getPrice().getAmount())
                .setCreatedAt(bookingCreatedEvent.getCreatedAt().toInstant())
                .setPaymentBookingStatus(PaymentBookingStatus.CANCELLED)
                .build();
    }

    public CinemaApprovalRequestAvroModel bookingPaidEventToCinemaApprovalRequestAvroModel(BookingPaidEvent bookingPaidEvent ) {
        Booking booking = bookingPaidEvent.getBooking();
        return CinemaApprovalRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setCustomerId(booking.getCustomerId().getValue().toString())
                .setBookingId(booking.getId().getValue().toString())
                .setMovieId(booking.getMovie().getId().toString())
                .setShowId(booking.getShow().getId().toString())
                .setCinemaId(booking.getCinemaId().getValue().toString())
                .setCinemaHallId(booking.getCinemaHallId().getValue().toString())
                .setCinemaBookingStatus(com.onboard.cinema.book.show.kafka.booking.avro.model.CinemaBookingStatus
                        .valueOf(booking.getBookingStatus().name()))
                .setSeats( booking.get)
                .setCreatedAt(bookingPaidEvent.getCreatedAt().toInstant())
                .setCinemaBookingStatus(CinemaBookingStatus.PAID)
                .build();

    }


}
