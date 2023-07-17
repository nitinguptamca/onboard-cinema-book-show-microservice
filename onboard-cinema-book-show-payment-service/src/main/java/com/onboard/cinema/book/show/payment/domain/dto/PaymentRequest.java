package com.onboard.cinema.book.show.payment.domain.dto;


import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PaymentRequest {
    private String id;
    private String sagaId;
    private String customerId;
    private String bookingId;
    private String movieId;
    private String showId;
    private String cinemaId;
    private String cinemaHallId;
    private BigDecimal price;
    private Instant createdAt;
    private PaymentBookingStatus paymentBookingStatus;


}
