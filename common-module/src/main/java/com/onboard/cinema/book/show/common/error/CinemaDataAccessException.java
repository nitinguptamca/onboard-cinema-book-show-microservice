package com.onboard.cinema.book.show.common.error;

public class CinemaDataAccessException extends RuntimeException{
    public CinemaDataAccessException(String message) {
        super(message);
    }

    public CinemaDataAccessException(String message, Throwable cause){
        super(message, cause);
    }
}
