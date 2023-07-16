package com.onboard.cinema.book.show.booking.service.ports.input.message.listener.payment;

import com.onboard.cinema.book.show.booking.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}
