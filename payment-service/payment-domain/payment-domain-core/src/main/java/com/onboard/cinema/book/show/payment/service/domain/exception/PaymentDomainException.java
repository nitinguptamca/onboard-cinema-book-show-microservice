package com.onboard.cinema.book.show.payment.service.domain.exception;


import com.onboard.cinema.book.show.domain.error.DomainException;

public class PaymentDomainException extends DomainException {

    public PaymentDomainException(String message) {
        super(message);
    }

    public PaymentDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
