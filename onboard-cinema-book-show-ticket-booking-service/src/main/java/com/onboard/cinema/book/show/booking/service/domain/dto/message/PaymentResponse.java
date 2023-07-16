package com.onboard.cinema.book.show.booking.service.domain.dto.message;

import com.onboard.cinema.book.show.common.valueobject.PaymentStatus;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PaymentResponse {
    private String id;
    private String sagaId;
    private String bookingId;
    private String paymentId;
    private String customerId;
    private String movieId;
    private String showId;
    private String cinemaId;
    private String cinemaHallId;
    private BigDecimal price;
    private Instant createdAt;
    private PaymentStatus paymentStatus;
    private List<String> failureMessages;

}
