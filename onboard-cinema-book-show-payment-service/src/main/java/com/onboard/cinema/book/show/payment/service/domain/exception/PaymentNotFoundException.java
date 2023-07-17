package com.onboard.cinema.book.show.payment.service.domain.exception;


import com.onboard.cinema.book.show.common.error.DomainException;

public class PaymentNotFoundException extends DomainException {

    public PaymentNotFoundException(String message) {
        super(message);
    }

    public PaymentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
