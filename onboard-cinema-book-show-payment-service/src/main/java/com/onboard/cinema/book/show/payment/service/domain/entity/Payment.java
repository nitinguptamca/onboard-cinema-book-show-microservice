package com.onboard.cinema.book.show.payment.service.domain.entity;


import com.onboard.cinema.book.show.common.entity.AggregateRoot;
import com.onboard.cinema.book.show.common.valueobject.BookingId;
import com.onboard.cinema.book.show.common.valueobject.CinemaHallId;
import com.onboard.cinema.book.show.common.valueobject.CinemaId;
import com.onboard.cinema.book.show.common.valueobject.CustomerId;
import com.onboard.cinema.book.show.common.valueobject.Money;
import com.onboard.cinema.book.show.common.valueobject.MovieId;
import com.onboard.cinema.book.show.common.valueobject.PaymentStatus;
import com.onboard.cinema.book.show.common.valueobject.ShowId;
import com.onboard.cinema.book.show.payment.service.domain.valueobject.PaymentId;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Setter
@Getter
public class Payment extends AggregateRoot<PaymentId> {
    private final PaymentId paymentId;
    private final BookingId bookingId;
    private final CustomerId customerId;
    private final Money price;
    private PaymentStatus paymentStatus;
    private ZonedDateTime createdAt;
    private MovieId movieId;
    private CinemaId cinemaId;
    private CinemaHallId cinemaHallId;
    private ShowId showId;
    private int quantity;

    public void initializePayment() {
        setId(new PaymentId(UUID.randomUUID()));
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }

    public void validatePayment(List<String> failureMessages) {
        if (price == null || !price.isGreaterThanZero()) {
            failureMessages.add("Total price must be greater than zero!");
        }
    }

    public void updateStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


}
