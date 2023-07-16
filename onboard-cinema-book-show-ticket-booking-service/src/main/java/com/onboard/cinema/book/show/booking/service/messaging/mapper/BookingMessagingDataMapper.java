package com.onboard.cinema.book.show.booking.service.messaging.mapper;

import com.onboard.cinema.book.show.booking.domain.entiry.Booking;
import com.onboard.cinema.book.show.booking.domain.event.BookingCreatedEvent;
import com.onboard.cinema.book.show.booking.domain.event.BookingPaidEvent;
import com.onboard.cinema.book.show.booking.service.domain.dto.message.CinemaApprovalResponse;
import com.onboard.cinema.book.show.booking.service.domain.dto.message.PaymentResponse;
import com.onboard.cinema.book.show.common.valueobject.BookingApprovalStatus;
import com.onboard.cinema.book.show.common.valueobject.PaymentStatus;
import com.onboard.cinema.book.show.kafka.booking.avro.model.CinemaApprovalRequestAvroModel;
import com.onboard.cinema.book.show.kafka.booking.avro.model.CinemaApprovalResponseAvroModel;
import com.onboard.cinema.book.show.kafka.booking.avro.model.CinemaBookingStatus;
import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus;
import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel;
import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentResponseAvroModel;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class BookingMessagingDataMapper {
    public PaymentRequestAvroModel bookingCreatedEventToPaymentRequestAvroModel(BookingCreatedEvent bookingCreatedEvent) {
        Booking booking = bookingCreatedEvent.getBooking();
        return PaymentRequestAvroModel.newBuilder()
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

    public PaymentRequestAvroModel bookingCancelledEventToPaymentRequestAvroModel(BookingCreatedEvent bookingCreatedEvent) {
        Booking booking = bookingCreatedEvent.getBooking();
        return PaymentRequestAvroModel.newBuilder()
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

    public CinemaApprovalRequestAvroModel bookingPaidEventToCinemaApprovalRequestAvroModel(BookingPaidEvent bookingPaidEvent) {
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
                .setQuantity(BigDecimal.valueOf(booking.getQuantity()))
                .setCreatedAt(bookingPaidEvent.getCreatedAt().toInstant())
                .setCinemaBookingStatus(CinemaBookingStatus.PAID)
                .build();

    }

    public PaymentResponse paymentResponseAvroModelToPaymentResponse(PaymentResponseAvroModel
                                                                             paymentResponseAvroModel) {
        return PaymentResponse.builder()
                .id(paymentResponseAvroModel.getId())
                .sagaId(paymentResponseAvroModel.getSagaId())
                .paymentId(paymentResponseAvroModel.getPaymentId())
                .customerId(paymentResponseAvroModel.getCustomerId())
                .movieId(paymentResponseAvroModel.getMovieId())
                .showId(paymentResponseAvroModel.getShowId())
                .bookingId(paymentResponseAvroModel.getBookingId())
                .cinemaHallId(paymentResponseAvroModel.getCinemaHallId())
                .price(paymentResponseAvroModel.getPrice())
                .createdAt(paymentResponseAvroModel.getCreatedAt())
                .paymentStatus(PaymentStatus.valueOf(
                        paymentResponseAvroModel.getPaymentStatus().name()))
                .failureMessages(paymentResponseAvroModel.getFailureMessages())
                .build();
    }

    public CinemaApprovalResponse approvalResponseAvroModelToApprovalResponse(CinemaApprovalResponseAvroModel
                                                        cinemaApprovalResponseAvroModel) {
        return CinemaApprovalResponse.builder()
                .id(cinemaApprovalResponseAvroModel.getId())
                .sagaId(cinemaApprovalResponseAvroModel.getSagaId())
                .cinemaId(cinemaApprovalResponseAvroModel.getCinemaId())
                .bookingId(cinemaApprovalResponseAvroModel.getBookingId())
                .createdAt(cinemaApprovalResponseAvroModel.getCreatedAt())
                .paymentId(cinemaApprovalResponseAvroModel.getPaymentId())
                .customerId(cinemaApprovalResponseAvroModel.getCustomerId())
                .movieId(cinemaApprovalResponseAvroModel.getMovieId())
                .showId(cinemaApprovalResponseAvroModel.getShowId())
                .seats(cinemaApprovalResponseAvroModel.getSeats())
                .bookingApprovalStatus(BookingApprovalStatus.valueOf(
                                cinemaApprovalResponseAvroModel.getBookApprovalStatus().name()))
                .failureMessages(cinemaApprovalResponseAvroModel.getFailureMessages())
                .build();
    }


}
