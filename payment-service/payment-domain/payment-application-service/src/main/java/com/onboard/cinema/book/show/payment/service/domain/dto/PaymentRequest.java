package com.onboard.cinema.book.show.payment.service.domain.dto;


import com.onboard.cinema.book.show.domain.valueobject.PaymentBookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class PaymentRequest {
    private String id;
    private String sagaId;
    private String bookingId;
    private String customerId;
    private BigDecimal price;
    private Instant createdAt;
    private PaymentBookingStatus paymentBookingStatus;

    public void setPaymentBookingStatus(PaymentBookingStatus paymentBookingStatus) {
        this.paymentBookingStatus = paymentBookingStatus;
    }
}
