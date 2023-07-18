package com.onboard.cinema.book.show.payment.service.domain.exception;


import com.onboard.cinema.book.show.domain.error.DomainException;

public class PaymentApplicationServiceException extends DomainException {

    public PaymentApplicationServiceException(String message) {
        super(message);
    }

    public PaymentApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
