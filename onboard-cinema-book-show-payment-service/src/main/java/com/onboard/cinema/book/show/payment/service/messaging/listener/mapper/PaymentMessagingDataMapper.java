package com.onboard.cinema.book.show.payment.service.messaging.listener.mapper;

import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus;
import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel;
import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentResponseAvroModel;
import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentStatus;
import com.onboard.cinema.book.show.payment.domain.dto.PaymentRequest;
import com.onboard.cinema.book.show.payment.service.domain.event.PaymentCancelledEvent;
import com.onboard.cinema.book.show.payment.service.domain.event.PaymentCompletedEvent;
import com.onboard.cinema.book.show.payment.service.domain.event.PaymentFailedEvent;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class PaymentMessagingDataMapper {
    public PaymentRequest paymentRequestAvroModelToPaymentRequest(PaymentRequestAvroModel paymentRequestAvroModel) {
        return PaymentRequest.builder()
                .id(paymentRequestAvroModel.getId())
                .sagaId(paymentRequestAvroModel.getSagaId())
                .customerId(paymentRequestAvroModel.getCustomerId())
                .bookingId(paymentRequestAvroModel.getBookingId())
                .movieId(paymentRequestAvroModel.getMovieId())
                .showId(paymentRequestAvroModel.getShowId())
                .cinemaId(paymentRequestAvroModel.getCinemaId())
                .cinemaHallId(paymentRequestAvroModel.getCinemaHallId())
                .price(paymentRequestAvroModel.getPrice())
                .createdAt(paymentRequestAvroModel.getCreatedAt())
                .paymentBookingStatus(PaymentBookingStatus.valueOf(paymentRequestAvroModel.getPaymentBookingStatus().name()))
                .build();
    }

    public PaymentResponseAvroModel paymentCompletedEventToPaymentResponseAvroModel(PaymentCompletedEvent paymentCompletedEvent) {
        return PaymentResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setPaymentId(paymentCompletedEvent.getPayment().getId().getValue().toString())
                .setCustomerId(paymentCompletedEvent.getPayment().getCustomerId().getValue().toString())
                .setBookingId(paymentCompletedEvent.getPayment().getBookingId().getValue().toString())
                .setPrice(paymentCompletedEvent.getPayment().getPrice().getAmount())
                .setCreatedAt(paymentCompletedEvent.getCreatedAt().toInstant())
                .setMovieId(paymentCompletedEvent.getPayment().getMovieId().toString())
                .setCinemaHallId(paymentCompletedEvent.getPayment().getCinemaHallId().toString())
                .setShowId(paymentCompletedEvent.getPayment().getShowId().toString())
                .setPaymentId(paymentCompletedEvent.getPayment().getCustomerId().toString())
                .setPaymentStatus(PaymentStatus.valueOf(paymentCompletedEvent.getPayment().getPaymentStatus().name()))
                .setFailureMessages(paymentCompletedEvent.getFailureMessages())
                .build();
    }

    public PaymentResponseAvroModel
    paymentCancelledEventToPaymentResponseAvroModel(PaymentCancelledEvent paymentCancelledEvent) {
        return PaymentResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setPaymentId(paymentCancelledEvent.getPayment().getId().getValue().toString())
                .setCustomerId(paymentCancelledEvent.getPayment().getCustomerId().getValue().toString())
                .setBookingId(paymentCancelledEvent.getPayment().getBookingId().getValue().toString())
                .setPrice(paymentCancelledEvent.getPayment().getPrice().getAmount())
                .setCreatedAt(paymentCancelledEvent.getCreatedAt().toInstant())
                .setMovieId(paymentCancelledEvent.getPayment().getMovieId().toString())
                .setCinemaHallId(paymentCancelledEvent.getPayment().getCinemaHallId().toString())
                .setShowId(paymentCancelledEvent.getPayment().getShowId().toString())
                .setPaymentId(paymentCancelledEvent.getPayment().getCustomerId().toString())
                .setPaymentStatus(PaymentStatus.valueOf(paymentCancelledEvent.getPayment().getPaymentStatus().name()))
                .setFailureMessages(paymentCancelledEvent.getFailureMessages())
                .build();
    }

    public PaymentResponseAvroModel
    paymentFailedEventToPaymentResponseAvroModel(PaymentFailedEvent paymentFailedEvent) {
        return PaymentResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setPaymentId(paymentFailedEvent.getPayment().getId().getValue().toString())
                .setCustomerId(paymentFailedEvent.getPayment().getCustomerId().getValue().toString())
                .setBookingId(paymentFailedEvent.getPayment().getBookingId().getValue().toString())
                .setPrice(paymentFailedEvent.getPayment().getPrice().getAmount())
                .setCreatedAt(paymentFailedEvent.getCreatedAt().toInstant())
                .setMovieId(paymentFailedEvent.getPayment().getMovieId().toString())
                .setCinemaHallId(paymentFailedEvent.getPayment().getCinemaHallId().toString())
                .setShowId(paymentFailedEvent.getPayment().getShowId().toString())
                .setPaymentId(paymentFailedEvent.getPayment().getCustomerId().toString())
                .setPaymentStatus(PaymentStatus.valueOf(paymentFailedEvent.getPayment().getPaymentStatus().name()))
                .setFailureMessages(paymentFailedEvent.getFailureMessages())
                .build();
    }

}
