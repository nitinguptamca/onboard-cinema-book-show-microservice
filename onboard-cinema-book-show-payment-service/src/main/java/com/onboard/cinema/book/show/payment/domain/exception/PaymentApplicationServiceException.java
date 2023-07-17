package com.onboard.cinema.book.show.payment.domain.exception;


import com.onboard.cinema.book.show.common.error.DomainException;

public class PaymentApplicationServiceException extends DomainException {

    public PaymentApplicationServiceException(String message) {
        super(message);
    }

    public PaymentApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
