package com.onboard.cinema.book.show.booking.exception.handler;

import com.onboard.cinema.book.show.booking.domain.exception.BookingDomainException;
import com.onboard.cinema.book.show.booking.domain.exception.MovieNotFoundException;
import com.onboard.cinema.book.show.booking.domain.exception.ShowHouseFullException;
import com.onboard.cinema.book.show.common.error.ErrorDTO;
import com.onboard.cinema.book.show.common.error.handler.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class OrderGlobalExceptionHandler extends GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {BookingDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(BookingDomainException bookingDomainException) {
        log.error(bookingDomainException.getMessage(), bookingDomainException);
        return ErrorDTO.builder().code(HttpStatus.BAD_REQUEST.getReasonPhrase()).message(bookingDomainException.getMessage()).build();
    }

    @ResponseBody
    @ExceptionHandler(value = {MovieNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(MovieNotFoundException movieNotFoundException) {
        log.error(movieNotFoundException.getMessage(), movieNotFoundException);
        return ErrorDTO.builder().code(HttpStatus.NOT_FOUND.getReasonPhrase()).message(movieNotFoundException.getMessage()).build();
    }

    @ResponseBody
    @ExceptionHandler(value = {ShowHouseFullException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(ShowHouseFullException showHouseFullException) {
        log.error(showHouseFullException.getMessage(), showHouseFullException);
        return ErrorDTO.builder().code(HttpStatus.NOT_FOUND.getReasonPhrase()).message(showHouseFullException.getMessage()).build();
    }

}

