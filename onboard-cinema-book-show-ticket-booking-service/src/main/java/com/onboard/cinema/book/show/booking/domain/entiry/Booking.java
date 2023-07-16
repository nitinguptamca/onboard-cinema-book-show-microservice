package com.onboard.cinema.book.show.booking.domain.entiry;

import com.onboard.cinema.book.show.booking.domain.exception.BookingDomainException;
import com.onboard.cinema.book.show.booking.domain.valueobject.BookingShowId;
import com.onboard.cinema.book.show.booking.domain.valueobject.StreetAddress;
import com.onboard.cinema.book.show.booking.domain.valueobject.TrackingId;
import com.onboard.cinema.book.show.common.entity.AggregateRoot;
import com.onboard.cinema.book.show.common.valueobject.BookingId;
import com.onboard.cinema.book.show.common.valueobject.BookingStatus;
import com.onboard.cinema.book.show.common.valueobject.CinemaHallId;
import com.onboard.cinema.book.show.common.valueobject.CinemaHallSeatId;
import com.onboard.cinema.book.show.common.valueobject.CinemaId;
import com.onboard.cinema.book.show.common.valueobject.CustomerId;
import com.onboard.cinema.book.show.common.valueobject.Money;
import com.onboard.cinema.book.show.common.valueobject.PaymentBookingStatus;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Booking extends AggregateRoot<BookingId> {
    public static final String FAILURE_MESSAGE_DELIMITER = ",";
    private final CustomerId customerId;
    private final CinemaHallId cinemaHallId;
    private final CinemaId cinemaId;
    private final CinemaHallSeatId cinemaHallSeatId;
    private final int showSeatId;
    private final Movie movie;
    private final Show show;
    private final StreetAddress streetAddress;
    private final Money price;
    private final List<BookShow> bookShowList;
    private TrackingId trackingId;
    private BookingStatus bookingStatus;
    private List<String> failureMessages;
    private PaymentBookingStatus paymentBookingStatus;

    public void initializeBooking() {
        setId(new BookingId(UUID.randomUUID()));
        trackingId = new TrackingId(UUID.randomUUID());
        bookingStatus = BookingStatus.PENDING;
        initializeBookingItems();
    }

    public void validateBooking() {
        validateInitialBooking();
        validateTotalPrice();
        validateItemsPrice();
    }

    public void pay() {
        if (bookingStatus != BookingStatus.PENDING) {
            throw new BookingDomainException("Booking is not in correct state for pay operation!");
        }
        bookingStatus = BookingStatus.PAID;
    }

    public void approve() {
        if (bookingStatus != BookingStatus.PAID) {
            throw new BookingDomainException("Booking is not in correct state for approve operation!");
        }
        bookingStatus = BookingStatus.APPROVED;
    }

    public void initCancel(List<String> failureMessages) {
        if (bookingStatus != BookingStatus.PAID) {
            throw new BookingDomainException("Booking is not in correct state for initCancel operation!");
        }
        bookingStatus = BookingStatus.CANCELLING;
        updateFailureMessages(failureMessages);
    }

    public void cancel(List<String> failureMessages) {
        if (!(bookingStatus == BookingStatus.CANCELLING || bookingStatus == BookingStatus.PENDING)) {
            throw new BookingDomainException("Booking is not in correct state for cancel operation!");
        }
        bookingStatus = BookingStatus.CANCELLED;
        updateFailureMessages(failureMessages);
    }

    private void updateFailureMessages(List<String> failureMessages) {
        if (this.failureMessages != null && failureMessages != null) {
            this.failureMessages.addAll(failureMessages.stream().filter(message -> !message.isEmpty()).toList());
        }
        if (this.failureMessages == null) {
            this.failureMessages = failureMessages;
        }
    }

    private void validateInitialBooking() {
        if (bookingStatus != null || getId() != null) {
            throw new BookingDomainException("Booking is not in correct state for initialization!");
        }
    }

    private void validateTotalPrice() {
        if (price == null || !price.isGreaterThanZero()) {
            throw new BookingDomainException("Total price must be greater than zero!");
        }
    }

    private void validateItemsPrice() {
        Money orderItemsTotal = bookShowList.stream().map(orderItem -> {
            validateItemPrice(orderItem);
            return orderItem.getSubTotal();
        }).reduce(Money.ZERO, Money::add);

        if (!price.equals(orderItemsTotal)) {
            throw new BookingDomainException("Total price: " + price.getAmount()
                    + " is not equal to Booking Shoe total: " + orderItemsTotal.getAmount() + "!");
        }
    }

    private void validateItemPrice(BookShow bookShow) {
        if (!bookShow.isPriceValid()) {
            throw new BookingDomainException("booking Show price: " + bookShow.getPrice().getAmount() +
                    " is not valid for Show " + bookShow.getShow().getId().getValue());
        }
    }

    private void initializeBookingItems() {
        long itemId = 1;
        for (BookShow bookShow : bookShowList) {
            bookShow.initializeBookingItem(super.getId(), new BookingShowId(itemId++));
        }
    }


}
