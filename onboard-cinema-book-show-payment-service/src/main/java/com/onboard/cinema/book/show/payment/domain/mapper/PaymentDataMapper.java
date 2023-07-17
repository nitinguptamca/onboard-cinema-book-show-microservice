package com.onboard.cinema.book.show.payment.domain.mapper;


import com.onboard.cinema.book.show.common.valueobject.BookingId;
import com.onboard.cinema.book.show.common.valueobject.CinemaHallId;
import com.onboard.cinema.book.show.common.valueobject.CinemaId;
import com.onboard.cinema.book.show.common.valueobject.CustomerId;
import com.onboard.cinema.book.show.common.valueobject.Money;
import com.onboard.cinema.book.show.common.valueobject.MovieId;
import com.onboard.cinema.book.show.common.valueobject.ShowId;
import com.onboard.cinema.book.show.payment.domain.dto.PaymentRequest;
import com.onboard.cinema.book.show.payment.service.domain.entity.Payment;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class PaymentDataMapper {

    public Payment paymentRequestModelToPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
                .bookingId(new BookingId(UUID.fromString(paymentRequest.getBookingId())))
                .customerId(new CustomerId(UUID.fromString(paymentRequest.getCustomerId())))
                .movieId(new MovieId(UUID.fromString(paymentRequest.getMovieId())))
                .showId(new ShowId(UUID.fromString(paymentRequest.getShowId())))
                .cinemaId(new CinemaId(UUID.fromString(paymentRequest.getCinemaId())))
                .cinemaHallId(new CinemaHallId(UUID.fromString(paymentRequest.getCinemaHallId())))
                .price(new Money(paymentRequest.getPrice()))
                .build();
    }
}
