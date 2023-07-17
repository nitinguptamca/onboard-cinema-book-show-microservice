package com.onboard.cinema.book.show.payment.domain.ports.input.message.listener;


import com.onboard.cinema.book.show.payment.domain.dto.PaymentRequest;

public interface PaymentRequestMessageListener {

    void completePayment(PaymentRequest paymentRequest);

    void cancelPayment(PaymentRequest paymentRequest);
}
