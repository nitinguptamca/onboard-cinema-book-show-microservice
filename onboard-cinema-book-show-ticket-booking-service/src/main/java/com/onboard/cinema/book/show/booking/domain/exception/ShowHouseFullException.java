package com.onboard.cinema.book.show.booking.domain.exception;

public class ShowHouseFullException extends RuntimeException {
    public ShowHouseFullException() {
    }

    public ShowHouseFullException(String message) {
        super(message);
    }

    public ShowHouseFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
