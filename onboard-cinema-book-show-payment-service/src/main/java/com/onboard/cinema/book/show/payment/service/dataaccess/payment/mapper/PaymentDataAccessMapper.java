package com.onboard.cinema.book.show.payment.service.dataaccess.payment.mapper;


import com.onboard.cinema.book.show.common.valueobject.BookingId;
import com.onboard.cinema.book.show.common.valueobject.CinemaHallId;
import com.onboard.cinema.book.show.common.valueobject.CinemaId;
import com.onboard.cinema.book.show.common.valueobject.CustomerId;
import com.onboard.cinema.book.show.common.valueobject.Money;
import com.onboard.cinema.book.show.common.valueobject.MovieId;
import com.onboard.cinema.book.show.common.valueobject.ShowId;
import com.onboard.cinema.book.show.payment.service.dataaccess.payment.entity.PaymentEntity;
import com.onboard.cinema.book.show.payment.service.domain.entity.Payment;
import com.onboard.cinema.book.show.payment.service.domain.valueobject.PaymentId;
import org.springframework.stereotype.Component;

@Component
public class PaymentDataAccessMapper {

    public PaymentEntity paymentToPaymentEntity(Payment payment) {
        return PaymentEntity.builder()
                .id(payment.getId().getValue())
                .customerId(payment.getCustomerId().getValue())
                .bookingId(payment.getBookingId().getValue())
                .cinemaHallId(payment.getCinemaHallId().getValue())
                .movieId(payment.getMovieId().getValue())
                .showId(payment.getShowId().getValue())
                .cinemaId(payment.getCinemaId().getValue())
                .quantity(payment.getQuantity())
                .price(payment.getPrice().getAmount())
                .status(payment.getPaymentStatus())
                .createdAt(payment.getCreatedAt())
                .build();
    }

    public Payment paymentEntityToPayment(PaymentEntity paymentEntity) {
        return Payment.builder()
                .paymentId(new PaymentId(paymentEntity.getId()))
                .customerId(new CustomerId(paymentEntity.getCustomerId()))
                .bookingId(new BookingId(paymentEntity.getBookingId()))
                .cinemaHallId(new CinemaHallId(paymentEntity.getCinemaHallId()))
                .cinemaId(new CinemaId(paymentEntity.getCinemaId()))
                .showId(new ShowId(paymentEntity.getShowId()))
                .movieId(new MovieId(paymentEntity.getMovieId()))
                .price(new Money(paymentEntity.getPrice()))
                .createdAt(paymentEntity.getCreatedAt())
                .quantity(paymentEntity.getQuantity()).build();
    }

}
