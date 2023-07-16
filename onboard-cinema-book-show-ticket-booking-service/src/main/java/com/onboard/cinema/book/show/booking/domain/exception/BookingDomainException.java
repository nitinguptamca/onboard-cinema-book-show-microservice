package com.onboard.cinema.book.show.booking.domain.exception;

public class BookingDomainException extends RuntimeException {
    public BookingDomainException() {
    }

    public BookingDomainException(String message) {
        super(message);
    }

    public BookingDomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingDomainException(Throwable cause) {
        super(cause);
    }

    public BookingDomainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
