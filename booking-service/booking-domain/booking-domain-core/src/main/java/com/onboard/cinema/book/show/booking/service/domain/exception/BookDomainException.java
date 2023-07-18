package com.onboard.cinema.book.show.booking.service.domain.exception;


import com.onboard.cinema.book.show.domain.error.DomainException;

public class BookDomainException extends DomainException {
    public BookDomainException(String message) {
        super(message);
    }

    public BookDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
