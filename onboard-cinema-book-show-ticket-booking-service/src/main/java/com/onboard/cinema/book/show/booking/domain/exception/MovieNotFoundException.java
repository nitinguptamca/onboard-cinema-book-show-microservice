package com.onboard.cinema.book.show.booking.domain.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String message) {
        super(message);
    }

    public MovieNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
