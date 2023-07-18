package com.onboard.cinema.book.show.payment.service.domain.exception;


import com.onboard.cinema.book.show.domain.error.DomainException;

public class PaymentNotAllowException extends DomainException {

    public PaymentNotAllowException(String message) {
        super(message);
    }

    public PaymentNotAllowException(String message, Throwable cause) {
        super(message, cause);
    }
}
