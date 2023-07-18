package com.onboard.cinema.book.show.payment.service.domain.mapper;


import com.onboard.cinema.book.show.domain.valueobject.BookingId;
import com.onboard.cinema.book.show.domain.valueobject.CustomerId;
import com.onboard.cinema.book.show.domain.valueobject.Money;
import com.onboard.cinema.book.show.payment.service.domain.dto.PaymentRequest;
import com.onboard.cinema.book.show.payment.service.domain.entity.Payment;
import com.onboard.cinema.book.show.payment.service.domain.event.PaymentEvent;
import com.onboard.cinema.book.show.payment.service.domain.outbox.model.BookEventPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PaymentDataMapper {

    public Payment paymentRequestModelToPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .bookingId(new BookingId(UUID.fromString(paymentRequest.getBookingId())))
                .customerId(new CustomerId(UUID.fromString(paymentRequest.getCustomerId())))
                .price(new Money(paymentRequest.getPrice()))
                .build();
    }

    public BookEventPayload paymentEventToOrderEventPayload(PaymentEvent paymentEvent) {
        return BookEventPayload.builder()
                .paymentId(paymentEvent.getPayment().getId().getValue().toString())
                .customerId(paymentEvent.getPayment().getCustomerId().getValue().toString())
                .bookingId(paymentEvent.getPayment().getBookingId().getValue().toString())
                .price(paymentEvent.getPayment().getPrice().getAmount())
                .createdAt(paymentEvent.getCreatedAt())
                .paymentStatus(paymentEvent.getPayment().getPaymentStatus().name())
                .failureMessages(paymentEvent.getFailureMessages())
                .build();
    }
}
